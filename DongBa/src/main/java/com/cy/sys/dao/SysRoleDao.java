package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.common.vo.CheckBox;
import com.cy.sys.entity.SysRole;
import com.cy.sys.pojo.SysRoleMenu;

@Mapper
public interface SysRoleDao {
	int getRowCount(@Param("name")String name);
	List<SysRole> findPageObject(@Param("name")String name,
								 @Param("startIndex")Integer startIndex,
								 @Param("pageSize")Integer pageSize);
	int insertObject(SysRole entity);
	SysRoleMenu findObjectById(Integer id);
	int deleteObject(Integer id);
	int updateObject(SysRole entity);
	List<CheckBox> findObjects();
	

}
