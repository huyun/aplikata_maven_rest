package com.aplikata.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.aplikata.util.YunDateUtil;

/**
 * @author Huyun
 * @version 1.0
 * @since 2012-02-22
 */

@Repository("publicDao")
public class PublicDaoImpl<M extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements
		PublicDao<M, PK> {
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private Class<M> entityClass;
	protected Class<? extends M> daoType;

	@SuppressWarnings("unchecked")
	public PublicDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] pt = ((ParameterizedType) type).getActualTypeArguments();
			daoType = (Class<M>) pt[0];
		}
	}

	@Override
	public Long add(M model) {
		return (Long) getHibernateTemplate().save(model);
	}

	@Override
	public void update(M model) {
		getHibernateTemplate().update(model);
	}

	@Override
	public M delete(M model) {
		Session session = getSessionFactory().getCurrentSession();
		session.delete(model);
		session.flush();
		return model;
	}

	@Override
	public M delete(Class<M> targetEntityClass, PK id) {
		Session session = getSessionFactory().getCurrentSession();
		M obj = session.load(targetEntityClass, id);
		session.delete(obj);
		session.flush();
		return obj;
	}

	@Override
	public M get(long id) {
		return (M) getSessionFactory().getCurrentSession().get(entityClass, id);
	}

	@Override
	public M get(Class<M> targetEntityClass, long id) {
		return (M) getSessionFactory().getCurrentSession().get(targetEntityClass, id);
	}

	@Override
	public List<M> getAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public List<M> getAll(Class<M> targetEntityClass) {
		return getHibernateTemplate().loadAll(targetEntityClass);
		/*
		 * Session session = sessionFactory.getCurrentSession();
		 * CriteriaQuery<M> cq =
		 * session.getCriteriaBuilder().createQuery(targetEntityClass);
		 * cq.from(targetEntityClass); return
		 * session.createQuery(cq).getResultList();
		 */
	}

	@SuppressWarnings("unchecked")
	@Override
	public M getUniqueByProperty(Class<M> className, String propertyName, Object propertyValue) {
		if (entityClass == null)
			entityClass = className;

		String queryString = new StringBuilder("from " + entityClass.getSimpleName() + " model where model.")
				.append(propertyName).append("= :value").toString();

		if (propertyValue instanceof Date) {
			propertyValue = YunDateUtil.formatDate((Date) propertyValue, "yyyy-MM-dd");
		}
		TypedQuery<M> query = getSessionFactory().getCurrentSession().createQuery(queryString)
				.setParameter("value", propertyValue);
		return query.setMaxResults(1).getSingleResult();
	}

	@Override
	public M getUniqueByProperty(String propertyName, Object propertyValue) {
		return getUniqueByProperty(null, propertyName, propertyValue);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> findByNamedQuery(String queryName) {
		return (List<M>) getHibernateTemplate().findByNamedQuery(queryName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> findByNamedQuery(String queryName, Object[] values) {
		return (List<M>) getHibernateTemplate().findByNamedQuery(queryName, values);
	}
}
