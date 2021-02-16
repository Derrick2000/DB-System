package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.sys.pojo.SysRoleMenu;

@Mapper
public interface SysRoleMenuDao {
	int deleteObjectsByMenuId(Integer menuId);
	int deleteObjectsByRoleId(Integer roleId);
	int insertObjects(@Param("roleId")Integer roleId,@Param("menuIds")Integer[] menuIds);
	List<Integer> findMenuIdsByRoleIds(List<Integer> roleIds);
	
	@Select("select menu_id from sys_role_menus where role_id=#{id}")
	List<Integer> findMenuIdsByRoleId(Integer id);
}
