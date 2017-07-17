package com.aplikata.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.aplikata.bo.TreeNode;
import com.aplikata.service.NodeService;
import com.google.gson.Gson;

@Path("menus")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class MenuResource {

	@Autowired
	NodeService nodeService;

	@GET
	public List<TreeNode> getAll() {
		List<Node> nodelist = nodeService.getAllMenus();
		Map<Long, TreeNode> map = new HashMap<Long, TreeNode>();
		for (Node node : nodelist) {
			if (node.getParent() == null) {
				TreeNode treeNode = new TreeNode(node.getId(), node.getLabel(), new Gson().toJson(node));
				treeNode.setExpanded(true);
				map.put(node.getId(), treeNode);
			} else {
				TreeNode parentNode = map.get(node.getParent().getId());

				List<TreeNode> list = parentNode.getChildren();
				if (list == null) {
					list = new ArrayList<TreeNode>();
				}
				TreeNode child = new TreeNode(node.getId(), node.getLabel(), new Gson().toJson(node));
				list.add(child);
				parentNode.setChildren(list);
				map.put(parentNode.getId(), parentNode);
			}
		}
		return new ArrayList<TreeNode>(map.values());
	}

	@PUT
	public TreeNode updateMenu(Node node) {
		try {
			Node parent = node.getParent();
			node = nodeService.updateNode(node);
			node.setParent(parent);
			return new TreeNode(node.getId(), node.getLabel(), new Gson().toJson(node));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@POST
	public TreeNode saveMenu(Node node) {
		try {
			node = nodeService.addMenu(node);
			return new TreeNode(node.getId(), node.getLabel(), new Gson().toJson(node));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{menuId}")
	public void deleteMenu(@PathParam("menuId") long nodeId){
		nodeService.deleteNode(nodeId);
	}
}
