package com.aplikata.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Domain domain;
	private Role role;
	private String userName;
	private String userPwd;
	private String userPwdOld;
	private String email;
	private String lastLoginTime;
	private boolean blocked;
	private String firstname;
	private String lastname;
	private String roleName;

	private String newPassword;
	private String repeatNewPassword;
	private String firstUrl;
	private String token;
	private String userMenus;

	public final static String USER_NAME = "userName";
	// public final static String USER_ROLE_ID = "role.id";

	public final static String LB_USER_NAME = "login_user";
	public final static String LB_USER_PWD = "login_password";
	public final static String LB_USER_NEWPWD = "login_new_password";
	public final static String LB_USER_CONFIRMPWD = "login_confim_password";

	public User() {
	}

	public User(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@XmlElement
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwdOld() {
		return this.userPwdOld;
	}

	public void setUserPwdOld(String userPwdOld) {
		this.userPwdOld = userPwdOld;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public int hashCode() {
		return id.toString().hashCode();
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@XmlElement
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@XmlElement
	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

	public String getFirstUrl() {
		return firstUrl;
	}

	public void setFirstUrl(String firstUrl) {
		this.firstUrl = firstUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserMenus() {
		return userMenus;
	}

	public void setUserMenus(String userMenus) {
		this.userMenus = userMenus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof User))
			return false;
		if (isNew() || ((User) o).isNew())
			return false;
		else
			return getId().equals(((User) o).getId());
	}

	public boolean isNew() {
		return getId() == null;
	}
}