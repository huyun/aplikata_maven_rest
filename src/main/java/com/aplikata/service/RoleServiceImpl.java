package com.aplikata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aplikata.bo.Node;
import com.aplikata.bo.Role;

@Service("roleService")
public class RoleServiceImpl extends PublicServiceImpl implements RoleService {

	@Override
	public Role addRole(Role role) throws Exception {
		Long idLong = add(role);
		role.setId(idLong);
		return role;
	}

	@Override
	public Role updateRole(Role role) throws Exception {
		return (Role) update(role);
	}

	@Override
	public Role deleteRole(long id) throws Exception {
		return (Role) delete(Role.class, id);
	}

	@Override
	public Role getRoleById(long id) {
		return (Role) get(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRole() throws Exception {
		return (List<Role>) getAll(Role.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Node> getRoleMenus(long roleId) {
		return getPublicDao().findByNamedQuery(Node.QY_FIND_BY_ROLE, new Object[]{roleId});
	}

}
