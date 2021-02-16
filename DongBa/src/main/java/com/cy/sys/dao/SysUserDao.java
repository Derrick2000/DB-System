package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysUser;

import com.cy.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	int getRowCount(String username);
	List<SysUserDeptVo> findPageObjects(String username,Integer startIndex,Integer pageSize);
	SysUser findUserByUserName(String username);
	
	int validById(@Param("id")Integer id, @Param("valid")Integer valid, @Param("modifiedUser")String modifiedUser);
	int insertObject(SysUser entity);
	SysUserDeptVo findObjectById(Integer id);
	int updateObject(SysUser entity);
	int updatePassword(@Param("password")String password,
						@Param("salt")String salt,
						@Param("id")Integer id);
	
}
