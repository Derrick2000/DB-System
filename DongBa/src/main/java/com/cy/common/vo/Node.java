package com.cy.common.vo;

import java.io.Serializable;

public class Node implements Serializable{
	

	private static final long serialVersionUID = -6041258640165261797L;
	
	private Integer id;
	private String name;
	private Integer parentId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
	
	
	
	
}
