package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
	List<Integer> findRoleIdsByUserId(Integer id);
	int deleteObjectsByRoleId(Integer roleId);
	
	int insertObject(Integer userId,Integer[]roleIds);
}
