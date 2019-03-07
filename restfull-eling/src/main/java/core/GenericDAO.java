package main.java.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import javax.persistence.EntityManager;
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

public abstract class GenericDAO<T> implements IGenericDAO<T> {

	protected EntityManager em;

	private final Class<T> type;
	
	private Map<Integer, T> map;

	protected final Persistence persistUnit;

	protected static final Logger logger = Logger.getLogger(GenericDAO.class.getName());

	@SuppressWarnings("unchecked")
	public GenericDAO(Persistence persist) {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
		persistUnit = persist;
		map = new HashMap<Integer, T>();
	}

	public void persist(T t) throws Exception {
		EntityManager em = null;
		try {
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception lors de la persistance de " + type);
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new Exception("Exception lors de la persistance de " + type);
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
	}

	public T create(T t) throws Exception {
	/*	EntityManager em = null;
		T tg = null;
		try {
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			em.getTransaction().begin();
			tg = em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception lors de la persistance de " + type);
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new Exception("Exception lors de la persistance de " + type);
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return tg;*/
		map.put(map.size(), t);
		return t;
	}

	public boolean delete(final Object id) {
	/*	EntityManager em = null;
		boolean res = true;
		try {
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			em.getTransaction().begin();
			em.remove(em.getReference(type, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Erreur lors de la suppression de " + type + " / " + e.getMessage());
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			res = false;
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return res;*/
		map.remove(id);
		return true;

	}

	public T get(final Object id) {
		/*EntityManager em = null;
		T tg = null;
		em = Session.getSession(persistUnit).getEmf().createEntityManager();
		try {
			tg = em.find(type, id);
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return tg;*/
		return map.get(id);
	}

	public T getByStringId(String strId) {
		int nump = Integer.parseInt(strId);
		return get(nump);
	}

	public List<T> findAll() {
		/*EntityManager em = null;
		List<T> tg = null;
		try {
			logger.info("findAll " + type + " - Start");
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> q = cb.createQuery(type);
			Root<T> b = q.from(type);
			q.select(b);
			TypedQuery<T> query = em.createQuery(q);
			// TypedQuery<T> query = em.createQuery("SELECT t FROM " +
			// type.getSimpleName() + " t ", type);
			tg = query.getResultList();
			logger.info("Loading all " + type + " from db (" + tg.size() + " occurences)");
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return tg;*/
		return Lists.newArrayList(map.values());
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
	 * TODO : Try to handle more attribute type (Date ...)
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
		EntityManager em = Session.getSession(persistUnit).getEmf().createEntityManager();
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
		try {
			em.close();
			em = null;
		} catch (Exception e) {
			logger.error("Erreur lors de la fermeture " + e);
		}
		return findByCriterias(criteriaQuery);
	}

	public List<T> findByCriterias(CriteriaQuery<T> cq) {
		EntityManager em = null;
		List<T> tg = null;
		try {
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			TypedQuery<T> query = em.createQuery(cq);
			tg = query.getResultList();
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return tg;
	}

	public T update(final T t) throws Exception {
		EntityManager em = null;
		T tu = null;
		try {
			em = Session.getSession(persistUnit).getEmf().createEntityManager();
			em.getTransaction().begin();
			tu = em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception lors de la mise a jour de " + type);
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new Exception("Exception lors de la mise a jour de " + type);
		} finally {
			if (em != null) {
				try {
					em.close();
					em = null;
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture " + e);
				}
			}
		}
		return tu;
	}

}
