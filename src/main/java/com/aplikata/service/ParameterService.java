package com.aplikata.service;

import java.util.List;

import com.aplikata.bo.Parameter;

public interface ParameterService {

	Parameter addParameter(Parameter parameter) throws Exception;

	Parameter updateParameter(Parameter parameter) throws Exception;

	Parameter deleteParameter(long id) throws Exception;

	Parameter getParameterById(long id);

	List<Parameter> getAllParentEnum() throws Exception;

	List<Parameter> getEnumChildren(Long parentId);

}
