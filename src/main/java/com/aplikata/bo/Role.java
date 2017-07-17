package com.aplikata.bo;


public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String protectUrl;
	private int grade;
	
	private String[] menus;
	public final static String QY_FIND_GREATER_GRADE = "Role.findGreaterGrade";
	public final static String QY_FIND_DOMAIN_GREATER_GRADE = "Role.findGreateGradeByDomain";
	public final static String QY_FIND_USER_GREATER_GRADE = "Role.findGreateGradeByUser";
	public final static String QY_FIND_BY_DOMAIN = "Role.findByDomain";
	
	public Role() {
	}

	public Long getId() {
		return this.id;
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

	public String getProtectUrl() {
		return protectUrl;
	}

	public void setProtectUrl(String protectUrl) {
		this.protectUrl = protectUrl;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String[] getMenus() {
		return menus;
	}

	public void setMenus(String[] menus) {
		this.menus = menus;
	}

}