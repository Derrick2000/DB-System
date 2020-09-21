package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.pojo.SysUserMenu;

@Mapper
public interface SysMenuDao {
	
	int updateObject(SysMenu entity);
	
	int insertObject(SysMenu entity);
	
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZtreeMenuNodes();
	
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObject(Integer id);
	
	@Select("select count(*) from sys_menus where parentId=#{id}")
	int getChildCount(Integer id);
	
	List<Map<String,Object>> findObjects();
	
	List<String> findPermissions(List<Integer> menuIds);
	
	List<SysUserMenu> findMenusByIds(@Param("menuIds")List<Integer> menuIds);
}
