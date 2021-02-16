package com.cy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.common.vo.Node;
import com.cy.sys.entity.SysMenu;
import com.cy.sys.pojo.SysUserMenu;

@Mapper
public interface SysMenuDao {
	List<Map<String,Object>> findObjects();
	int getChildCount(Integer id);
	int deleteObject(Integer id);
	List<Node> findZtreeMenuNodes();
	int insertObject(SysMenu entity);
	int updateObject(SysMenu entity);
	List<String> findPermissions(@Param("menuIds") List<Integer> menuIds);
	List<SysUserMenu> findMenusByIds(@Param("menuIds")List<Integer> menuIds);
	
}
