package com.aplikata.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplikata.dao.PublicDao;

/**
 * @author Huyun
 * @version 1.0
 * @since 2012-02-22
 */

@Repository("publicService")
public class PublicServiceImpl implements PublicService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private PublicDao publicDao;

	@SuppressWarnings("unchecked")
	@Override
	public Long add(Serializable model) {
		return (Long) publicDao.add(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Serializable update(Serializable model) {
		publicDao.update(model);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Serializable delete(Class<?> entityClass, Serializable serializable) {
		return publicDao.delete(entityClass, serializable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Serializable get(Class<?> entityClass, long id) {
		return publicDao.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<?> getAll(Class<?> entityClass) {
		return publicDao.getAll(entityClass);
	}

	@SuppressWarnings("rawtypes")
	public PublicDao getPublicDao() {
		return publicDao;
	}

	@SuppressWarnings("rawtypes")
	public void setPublicDao(PublicDao publicDao) {
		this.publicDao = publicDao;
	}

}
