package com.aplikata.service;

import java.util.List;

import com.aplikata.bo.Node;


public interface NodeService {

	List<Node> getAllMenus();

	Node addMenu(Node node) throws Exception;

	Node updateNode(Node node) throws Exception;

	Node deleteNode(long nodeId);
}
