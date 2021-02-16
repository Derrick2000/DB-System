package com.cy.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CheckBox implements Serializable {

	private static final long serialVersionUID = -4628299842403741514L;
	private Integer id;
	private String name;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}	
