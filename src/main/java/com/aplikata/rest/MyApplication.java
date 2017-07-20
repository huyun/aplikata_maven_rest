package com.aplikata.rest;

import org.glassfish.jersey.server.ResourceConfig;

import com.aplikata.CORSResponseFilter;

public class MyApplication extends ResourceConfig {
	public MyApplication() {
		register(DomainResource.class);
		register(UserResource.class);
		register(MenuResource.class);
		register(RoleResource.class);
		register(EnumResource.class);
		register(CORSResponseFilter.class);
	}
}
