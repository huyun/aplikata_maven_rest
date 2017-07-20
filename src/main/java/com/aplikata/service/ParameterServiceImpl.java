package com.aplikata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aplikata.bo.Parameter;

@Service("parameterService")
public class ParameterServiceImpl extends PublicServiceImpl implements ParameterService {

	@Override
	public Parameter addParameter(Parameter parameter) throws Exception {
		Long idLong = add(parameter);
		parameter.setId(idLong);
		return parameter;
	}

	@Override
	public Parameter updateParameter(Parameter parameter) throws Exception {
		return (Parameter) update(parameter);
	}

	@Override
	public Parameter deleteParameter(long id) throws Exception {
		return (Parameter) delete(Parameter.class, id);
	}

	@Override
	public Parameter getParameterById(long id) {
		return (Parameter) get(Parameter.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parameter> getAllParentEnum() throws Exception {
		return getPublicDao().findByNamedQuery(Parameter.QY_ENUM_PARENT);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Parameter> getEnumChildren(Long parentId) {
		if (parentId == null || parentId <= 0) {
			return null;
		}

		return getPublicDao().findByNamedQuery(Parameter.QY_ENUM_CHILDREN, new Object[]{parentId});
	}
}
