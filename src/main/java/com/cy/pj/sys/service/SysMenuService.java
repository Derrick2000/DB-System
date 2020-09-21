package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.pojo.SysUserMenu;

public interface SysMenuService {
	int updateObject(SysMenu entity);
	
	int saveObject(SysMenu entity);

	List<Node> findZtreeMenuNodes();
	
	int deleteObject(Integer id);
	
	List<Map<String,Object>> findObjects();
	
	List<SysUserMenu> findUserMenusByUserId(Integer id);
}
