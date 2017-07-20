package com.aplikata.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.NativeQuery;

/**
 * @author Huyun
 * @version 1.0
 * @since 2012-02-22
 */

public interface PublicDao<M extends Serializable, PK extends Serializable> {

	Serializable add(M model);

	M update(M model);

	M delete(M model);

	M delete(Class<M> targetEntityClass, PK id);

	M get(long id);

	M get(Class<M> targetEntityClass, long id);

	M getUniqueByProperty(Class<M> className, String propertyName, Object propertyValue);

	M getUniqueByProperty(String propertyName, Object propertyValue);

	List<M> findByNamedQuery(String queryName);

	List<M> findByNamedQuery(String queryName, Object[] values);

	List<M> getAll();

	List<M> getAll(Class<M> targetEntityClass);

	@SuppressWarnings("rawtypes")
	NativeQuery getSQLQuery(String sql);

}
