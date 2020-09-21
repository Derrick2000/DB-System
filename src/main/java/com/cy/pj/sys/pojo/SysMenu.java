package com.cy.pj.sys.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysMenu implements Serializable{

	private static final long serialVersionUID = -3390842818791655814L;
	private Integer id;
	private String name;
	private String url;
	private Integer type=1;
	private Integer sort;
	private String note;
	private Integer parentId;
	private String permission;
	private String createdUser;
	private String modifiedUser;
	private Date createdTime;
	private Date modifiedTime;
	
}
