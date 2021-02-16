package com.cy.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.common.vo.Node;
import com.cy.sys.entity.SysMenu;
import com.cy.sys.pojo.SysUserMenu;
public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	int deleteObject(Integer id);
	List<Node> findZtreeMenuNodes();
	int saveObject(SysMenu entity);
	int updateObject(SysMenu entity);
	List<SysUserMenu> findUserMenusByUserId(Integer id);
	
}
