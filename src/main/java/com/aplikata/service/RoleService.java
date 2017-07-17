package com.aplikata.service;

import java.util.List;

import com.aplikata.bo.Node;
import com.aplikata.bo.Role;


public interface RoleService {

	Role addRole(Role role) throws Exception;

	Role updateRole(Role role) throws Exception;

	Role deleteRole(long id) throws Exception;

	Role getRoleById(long id);

	List<Role> getAllRole() throws Exception;

	List<Node> getRoleMenus(long roleId);

}
