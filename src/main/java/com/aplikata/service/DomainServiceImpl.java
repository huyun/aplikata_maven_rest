package com.aplikata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aplikata.bo.Domain;
import com.aplikata.bo.Role;

@Service("domainService")
public class DomainServiceImpl extends PublicServiceImpl implements DomainService {

	@Override
	public Domain addDomain(Domain domain) throws Exception {
		Long idLong = add(domain);
		domain.setId(idLong);
		return domain;
	}

	@Override
	public Domain updateDomain(Domain domain) throws Exception {
		return (Domain) update(domain);
	}

	@Override
	public Domain deleteDomain(long id) throws Exception {
		return (Domain) delete(Domain.class, id);
	}

	@Override
	public Domain getDomainById(long id) {
		return (Domain) get(Domain.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getAllDomain() throws Exception {
		return (List<Domain>) getAll(Domain.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getDomainRoles(long domainId) {
		if (domainId <= 0) {
			return null;
		}
		return getPublicDao().findByNamedQuery(Role.QY_FIND_BY_DOMAIN, new Object[] { domainId });
	}
}
