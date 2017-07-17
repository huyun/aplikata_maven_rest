package com.aplikata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aplikata.bo.Node;

@Service("nodeService")
public class NodeServiceImpl extends PublicServiceImpl implements NodeService {

	@Override
    @SuppressWarnings("unchecked")
	public List<Node> getAllMenus(){
        return getPublicDao().findByNamedQuery(Node.QY_FIND_ALL_MENUS);
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Node addMenu(Node node) throws Exception{
		node.setType(1);
		if(node.getParent() == null){
			node.setLevel(1);
		}else{
			Node parent = (Node) getPublicDao().get(Node.class, node.getParent().getId());
			node.setParent(parent);
			node.setLevel(node.getParent().getLevel()+1);
		}
		
		Long idLong = add(node);
		node.setId(idLong);
		return node;
	}
	
	@Override
	public Node updateNode(Node node){
		return (Node) update(node);
	}
	
	@Override
	public Node deleteNode(long nodeId){
		return (Node) delete(Node.class, nodeId);
	}
}
