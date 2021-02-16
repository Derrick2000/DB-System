package com.cy.sys.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SysRoleMenu implements Serializable{
	
	private static final long serialVersionUID = -4815546448708109450L;
	private Integer id;
	private String name;
	private String note;
	private List<Integer> menuIds;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
