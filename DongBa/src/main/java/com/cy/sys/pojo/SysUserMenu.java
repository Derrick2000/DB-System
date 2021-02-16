package com.cy.sys.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SysUserMenu implements Serializable{

	
	private static final long serialVersionUID = 6494268053478249733L;
	private Integer id;
	public String name;
	private String url;
	private List<SysUserMenu> childs;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<SysUserMenu> getChilds() {
		return childs;
	}
	public void setChilds(List<SysUserMenu> childs) {
		this.childs = childs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
