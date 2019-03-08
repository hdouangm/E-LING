package main.java.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.guava.Lists;



/**
 * Classe definissant un Objet d'Accès aux Données Générique.<br/>
 * 
 * @param <T>
 */
public abstract class GenericDAO<T>  {

	@PersistenceContext(unitName ="JPAPU")
	protected EntityManager em;


	public void persist(T t) throws Exception {
		try {
			em.persist(t);
		} catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Exception lors de la persistance de " + t.getClass());
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new Exception("Exception lors de la persistance de " + t.getClass());
		}
	}

	public T create(T t) throws Exception {
		T tg = null;
		try {
			tg = em.merge(t);
		} catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Exception lors de la persistance de " + t.getClass());
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new Exception("Exception lors de la persistance de " + t.getClass());
		}
		return tg;
	}

	public boolean delete(final Object id) {
		boolean res = true;
		try {

			em.remove(id);

		} catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Erreur lors de la suppression : " + e.getMessage());
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			res = false;
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public T get(final Object id) {
		T tg = null;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		Class<T> type = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			tg = em.find(type, id);
		} catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Erreur lors de la fermeture " + e);
		}
			
	
		return tg;
	}

	public T getByStringId(String strId) {
		int nump = Integer.parseInt(strId);
		return get(nump);
	}

	public List<T> findAll() {
		List<T> tg = null;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			Logger.getLogger(GenericDAO.class).info("findAll " + t.getClass() + " - Start");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> q = cb.createQuery(type);
			Root<T> b = q.from(type);
			q.select(b);
			TypedQuery<T> query = em.createQuery(q);
			// TypedQuery<T> query = em.createQuery("SELECT t FROM " +
			// t.getClass().getSimpleName() + " t ", t.getClass());
			tg = query.getResultList();
			Logger.getLogger(GenericDAO.class).info("Loading all " + t.getClass() + " from db (" + tg.size() + " occurences)");
		}catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Erreur lors de la fermeture " + e);
		}
		return tg;
	}

	public List<T> findByParamsExact(Map<String, String> params) {
		return findByParams(params, false);
	}

	public List<T> findByParamExact(String key, String value) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return findByParamsExact(params);
	}

	public List<T> findByParam(String key, String value) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return findByParams(params, false);
	}

	/**
	 * Map must contains key = entity attribute name <br/>
	 * Handle "sub-attribute" (like 'contrat.proprietaire.prenom') <br/>
	 * TODO : Try to handle more attribute t.getClass() (Date ...)
	 * 
	 * @param params
	 * @param like
	 *            : if true use LIKE expression, else use EQUAL (=)
	 * @return
	 */
	public List<T> findByParams(Map<String, String> params, boolean like) {
		if (params == null || params.size() < 1) {
			return new ArrayList<T>();
		}
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>) pt.getActualTypeArguments()[0];
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
		Root<T> from = criteriaQuery.from(type);
		criteriaQuery.select(from);
		Predicate[] ap = new Predicate[params.keySet().size()];
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			String param_name = entry.getKey();
			if (like) {
				Path<String> exp;
				if (!param_name.contains(".")) {
					exp = from.get(param_name);
				} else {
					String[] expArray = param_name.split("\\.");
					exp = from.get(expArray[0]);
					for (int j = 1; j < expArray.length; j++) {
						exp = exp.get(expArray[i]);
					}
				}
				ap[i++] = cb.like(exp, entry.getValue());
			} else {
				Path<Object> exp;
				if (!param_name.contains(".")) {
					exp = from.get(param_name);
				} else {
					String[] expArray = param_name.split("\\.");
					exp = from.get(expArray[0]);
					for (int j = 1; j < expArray.length; j++) {
						exp = exp.get(expArray[j]);
					}
				}
				if (entry.getValue() == null) {
					ap[i++] = cb.isNull(exp);
				} else {
					ap[i++] = cb.equal(exp, entry.getValue());
				}
			}
		}
		criteriaQuery.where(cb.and(ap));
		return findByCriterias(criteriaQuery);
	}

	public List<T> findByCriterias(CriteriaQuery<T> cq) {
		List<T> tg = null;
		try {

			TypedQuery<T> query = em.createQuery(cq);
			tg = query.getResultList();
		}catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Erreur lors de la fermeture " + e);
		}
		return tg;
	}

	public T update(final T t) throws Exception {
		T tu = null;
		try {
			tu = em.merge(t);
		} catch (Exception e) {
			Logger.getLogger(GenericDAO.class).error("Exception lors de la mise a jour de " + t.getClass());
			e.printStackTrace();
			throw new Exception("Exception lors de la mise a jour de " + t.getClass());
		}
		return tu;
	}

}
