package com.aplikata.bo;

public class Parameter implements java.io.Serializable {

	public final static String QY_ENUM_PARENT = "Parameter.getAllParentEnum";
	public final static String QY_ENUM_CHILDREN = "Parameter.getChildrenEnum";

	private static final long serialVersionUID = 1L;
	private Long id;
	private Parameter parent;
	private int type;
	private String name;
	private String lang;
	private int value;
	private int sort;

	/** default constructor */
	public Parameter() {
	}

	public Parameter(Parameter parent) {
		this.parent = parent;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Parameter getParent() {
		return parent;
	}

	public void setParent(Parameter parent) {
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameter other = (Parameter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}