package com.aplikata.bo;

import java.io.Serializable;

public class Domain implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private boolean blocked;
	private String address;
	private Role[] roles;

	// Constructors
	public Domain() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

}