package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.pojo.Node;

@Mapper
public interface SysRoleMenuDao {
	
	@Delete("delete from sys_role_menus where menu_id=#{menuId}")
	int deleteObjectsByMenuId(Integer menuId);
	
	int deleteObjectsByRoleId(Integer roleId);
	
	int insertObjects(@Param("roleId") Integer roleId,
					  @Param("menuIds") Integer[] menuIds);
	
	List<Integer> findMenuIdsByRoleIds(List<Integer> roleIds);
	
}
