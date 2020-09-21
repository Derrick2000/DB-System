package com.cy.pj.sys.service;

import java.util.Map;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserDept;

public interface SysUserService {
	
	 PageObject<SysUserDept> findPageObjects(String username,Integer pageCurrent);

	 int saveObject(SysUser entity,Integer[] roleIds);
	 
	 Map<String,Object> findObjectById(Integer userId);

	 int updateObject(SysUser entity,Integer[] roleIds);

	 int updatePassword(String password,String newPassword,String checkPassword);
	 
	 int validById(Integer id,Integer valid);
}
