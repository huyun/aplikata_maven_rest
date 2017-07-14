package com.aplikata.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	public MyApplication() {
		register(DomainResource.class);
		register(UserResource.class);
	}
}
