package com.aplikata.service;

import java.util.List;

import com.aplikata.bo.Domain;

public interface DomainService {
	Domain addDomain(Domain domain) throws Exception;
	Domain updateDomain(Domain domain) throws Exception;
	Domain deleteDomain(long id) throws Exception;
	Domain getDomainById(long id);
	List<Domain> getAllDomain() throws Exception;
}
