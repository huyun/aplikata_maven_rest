package com.aplikata.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.aplikata.Constants;
import com.aplikata.bo.Parameter;
import com.aplikata.service.ParameterService;

@Path("enums")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EnumResource {

	@Autowired
	ParameterService parameterService;

	@GET
	@Path("/parents")
	public List<Parameter> getEnumParens() {
		try {
			return parameterService.getAllParentEnum();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/{parameterId}")
	public Parameter getParameter(@PathParam("parameterId") long id) {
		return parameterService.getParameterById(id);
	}

	@POST
	public Parameter saveParameter(Parameter parameter) {
		try {
			parameter.setType(Constants.PARA_ENUM);
			return parameterService.addParameter(parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PUT
	public Parameter updateParameter(Parameter parameter) {
		try {
			parameter.setType(Constants.PARA_ENUM);
			return parameterService.updateParameter(parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DELETE
	@Path("/{parameterId}")
	public Parameter removeParameter(@PathParam("parameterId") long id) {
		try {
			return parameterService.deleteParameter(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/children/{parentId}")
	public List<Parameter> getEnumChildren(@PathParam("parentId") long id) {
		try {
			return parameterService.getEnumChildren(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
