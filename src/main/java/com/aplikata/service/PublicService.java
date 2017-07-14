package com.aplikata.service;

import java.io.Serializable;



public interface PublicService {

	Serializable add(Serializable model) throws Exception;

	Serializable update(Serializable model);

	Serializable delete(Class<?> entityClass, Serializable serializable);

	Serializable get(Class<?> entityClass, long id);

}
