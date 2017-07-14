package com.aplikata.bo;


public class NodeItem {
	private String label;
	private String data;
	private String icon;
	private String[] routerLink; 
	public NodeItem() {

	}

	public NodeItem(String label, String data) {
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

	public String[] getRouterLink() {
		return routerLink;
	}

	public void setRouterLink(String[] routerLink) {
		this.routerLink = routerLink;
	}

}
