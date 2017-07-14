package com.aplikata.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Huyun
 * @version 1.0
 * @since 2012-02-22
 */

public interface PublicDao<M extends Serializable, PK extends Serializable> {

	Serializable add(M model);

	void update(M model);

	M delete(M model);

	M delete(Class<M> targetEntityClass, PK id);

	M get(long id);

	M get(Class<M> targetEntityClass, long id);

	List<M> getAll();

	List<M> getAll(Class<M> targetEntityClass);

	M getUniqueByProperty(Class<M> className, String propertyName, Object propertyValue);

	M getUniqueByProperty(String propertyName, Object propertyValue);

	List<M> findByNamedQuery(String queryName);

	List<M> findByNamedQuery(String queryName, Object[] values);

}
