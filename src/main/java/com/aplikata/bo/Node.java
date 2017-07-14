package com.aplikata.bo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Node implements Serializable, Comparator<Node> {
	public static final String DESCRIPTION = "description";

	private static final long serialVersionUID = 1L;
	private Long id;
	private Node parent;
	private int type;
	private String label;
	private String url;
	private int sort;
	private int level;
	private String icon;

	private List<NodeItem> items;
	public final static String QY_FIND_USER_NODES = "Node.findUserNodes";
	public final static String QY_FIND_ALL_MENUS = "Node.findAllMenus";

	public Node() {
	}

	public Node(Node parent) {
		this.parent = parent;
	}

	public Node(Integer type) {
		this.type = type;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	@Override
	public int compare(Node o1, Node o2) {
		Integer order1 = ((Node) o1).getSort();
		Integer order2 = ((Node) o2).getSort();

		if (order1 == null)
			return (order2 == null) ? 0 : 1;

		if (order2 == null) {
			return -1;
		}

		return order1.compareTo(order2);
	}
}