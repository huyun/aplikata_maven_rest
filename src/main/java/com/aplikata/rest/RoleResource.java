package com.aplikata.rest;

import java.util.ArrayList;
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

import com.aplikata.bo.Node;
import com.aplikata.bo.Role;
import com.aplikata.bo.TreeNode;
import com.aplikata.service.RoleService;
import com.google.gson.Gson;

@Path("roles")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RoleResource {

	@Autowired
	RoleService roleService;

	@GET
	public List<Role> getAll() {
		try {
			return roleService.getAllRole();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PUT
	public Role updateRole(Role role) {
		try {
			role = roleService.updateRole(role);
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@POST
	public Role saveRole(Role role) {
		try {
			role = roleService.addRole(role);
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{roleId}")
	public void deleteRole(@PathParam("roleId") long roleId){
		try {
			roleService.deleteRole(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("menus/{roleId}")
	public List<TreeNode> getMenus(@PathParam("roleId") String roleId) {
		try {
			List<Node> nodelist = roleService.getRoleMenus(Long.parseLong(roleId));

			List<TreeNode> treeNodes = new ArrayList<TreeNode>();
			for (Node node : nodelist) {
				treeNodes.add(new TreeNode(node.getId(), node.getLabel(), new Gson().toJson(node)));
			}
			return treeNodes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
