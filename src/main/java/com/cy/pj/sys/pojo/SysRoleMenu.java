package com.cy.pj.sys.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SysRoleMenu implements Serializable{

	private static final long serialVersionUID = 3005573447952589565L;
	private Integer id;
	private String name;
	private String note;
	private List<Integer> menuIds;
}
