package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;

public interface SysRoleService {

	
	PageObject<SysRole> findPageObjects(String name, Integer pageCurrent);

	int saveObject(SysRole entity,Integer[] menuIds);

	SysRoleMenu findObjectById(Integer id);
	
	int updateObject(SysRole entity, Integer[] menuIds);

	int deleteObject(Integer id);
	
	List<CheckBox> findObjects();
}
