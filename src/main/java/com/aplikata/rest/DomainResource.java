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

import com.aplikata.bo.Domain;
import com.aplikata.service.DomainService;

@Path("domains")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class DomainResource {
	
	@Autowired
	DomainService domainService;

	@GET
	public List<Domain> getDomains(){
		try {
			return domainService.getAllDomain();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/{domainId}")
	public Domain getDomain(@PathParam("domainId") long id){
		return domainService.getDomainById(id);
	}
	
	@POST
    public Domain saveDomain(Domain domain){
    	try {
			return domainService.addDomain(domain);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @PUT
    public Domain updateDomain(Domain domain){
    	try {
			return domainService.updateDomain(domain);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @DELETE
    @Path("/{domainId}")
    public Domain removeDomain(@PathParam ("domainId") long id ){
    	try {
			return domainService.deleteDomain(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
