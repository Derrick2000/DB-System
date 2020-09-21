package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;

@Mapper
public interface SysRoleDao {
	
	
	int insertObject(SysRole entity);
	
	int getRowCount(@Param("name")String name);
	
	List<SysRole> findPageObjects(String name,Integer startIndex, Integer pageSize);

	SysRoleMenu findObjectById(Integer id);
	
	int updateObject(SysRole entity);
	
	int deleteObject(Integer id);
	
	List<CheckBox> findObjects();
}
