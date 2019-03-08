package application.eling.domain;

import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaQuery;

public interface IGenericDAO<T> {

public T create(T t) throws Exception;

public T get(Object id);

public T update(T t) throws Exception;

public boolean delete(Object id);

public T getByStringId(String strId);

public List<T> findAll();

public List<T> findByCriterias(CriteriaQuery<T> cq);

public void persist(T t) throws Exception;

public List<T> findByParams(Map<String, String> params, boolean like);

public List<T> findByParamsExact(Map<String, String> params);

}
