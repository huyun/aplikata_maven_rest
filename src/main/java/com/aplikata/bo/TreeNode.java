package com.aplikata.bo;

import java.util.List;

public class TreeNode {
	private Long id;
	private String label;
	private String data;
	private String icon;
	private List<NodeItem> items;
	private List<TreeNode> children;
	private boolean expanded;
	
	public TreeNode() {

	}

	public TreeNode(Long id, String label, String data) {
		this.id = id;
		this.label = label;
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<NodeItem> getItems() {
		return items;
	}

	public void setItems(List<NodeItem> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

}
