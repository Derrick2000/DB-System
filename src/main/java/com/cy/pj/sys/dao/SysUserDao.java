package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserDept;

@Mapper
public interface SysUserDao {
	
	int getRowCount(String username);
	
	List<SysUserDept> findPageObjects(String username,Integer startIndex,Integer pageSize);

	int validById(@Param("id")Integer id,@Param("valid") Integer valid,@Param("modifiedUser")String modifiedUser);

	int insertObject(SysUser entity);
	
	SysUserDept findObjectById(Integer id);
	
	int updateObject(SysUser entity);
	
	int updatePassword(
			@Param("password")String password,
			@Param("salt")String salt,
			@Param("id")Integer id);
	
	@Select("select * from sys_users where username=#{username}")
	SysUser findUserByUsername(String username);
}
