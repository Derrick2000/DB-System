package com.cy.sys.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.common.vo.Node;
import com.cy.sys.dao.SysMenuDao;
import com.cy.sys.dao.SysRoleMenuDao;
import com.cy.sys.dao.SysUserRoleDao;
import com.cy.sys.entity.SysMenu;
import com.cy.sys.pojo.SysUserMenu;
import com.cy.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list = sysMenuDao.findObjects();
		if(list == null || list.size()==0) {
			throw new ServiceException("No corresponding Menu information");
		}
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id == null || id == 0) {
			throw new IllegalArgumentException("Please choose first");
		}
		int count = sysMenuDao.getChildCount(id);
		if(count > 0) {
			throw new ServiceException("Please delete child menu first");
		}
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		int rows = sysMenuDao.deleteObject(id);
		if(rows == 0) {
			throw new ServiceException("The menu may not exist");
		}
		return rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}

	@Override
	public int saveObject(SysMenu entity) {
		if(entity == null) {
			throw new IllegalArgumentException("Object cannot be null");
		}
		if(StringUtils.isEmpty(entity.getName())) {;
			throw new IllegalArgumentException("Menu name cannot be null");
		}
		int rows = sysMenuDao.insertObject(entity);
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		if(entity == null) {
			throw new IllegalArgumentException("Object cannot be null");
		}
		if(StringUtils.isEmpty(entity.getName())) {;
		throw new IllegalArgumentException("Menu name cannot be null");
		}
		int rows = sysMenuDao.updateObject(entity);
		return rows;
	}

	@Override
	public List<SysUserMenu> findUserMenusByUserId(Integer id) {
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds);	
		return sysMenuDao.findMenusByIds(menuIds);
	}
	
}
