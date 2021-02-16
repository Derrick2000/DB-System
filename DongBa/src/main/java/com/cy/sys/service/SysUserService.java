package com.cy.sys.service;

import java.util.Map;

import com.cy.common.bo.PageObject;
import com.cy.sys.pojo.SysUser;
import com.cy.sys.vo.SysUserDeptVo;

public interface SysUserService {
	PageObject<SysUserDeptVo> findPageObjects(String username,Integer pageCurrent);
	
	int updatePassword(String sourcePassword,String newPassword,String cfgPassword);
	Map<String,Object> findObjectById(Integer id);
	int updateObject(SysUser entity, Integer[] roleIds);
	int saveObject(SysUser entity, Integer[] roleIds);
	int validById(Integer id, Integer valid);
	
}
