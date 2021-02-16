package com.cy.sys.service;

import java.util.List;

import com.cy.common.bo.PageObject;
import com.cy.common.vo.CheckBox;
import com.cy.sys.entity.SysRole;
import com.cy.sys.pojo.SysRoleMenu;

public interface SysRoleService {
	PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	int saveObject(SysRole entity,Integer[] menuIds);
	SysRoleMenu findObjectById(Integer id);
	int deleteObject(Integer id);
	int updateObject(SysRole entity, Integer[] menuIds);
	List<CheckBox> findObjects();
	
}
