package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.pojo.SysUserMenu;
import com.cy.pj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@CacheEvict(value="menuCache",allEntries=true)
	@Override
	public int updateObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("The object cannot be empty");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("name cannot be empty");
		int rows=sysMenuDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("The record may not exist");
		return rows;
	}
	
	@Override
	public int saveObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("The object cannot be empty");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("name cannot be empty");
		int rows=sysMenuDao.insertObject(entity);
		return rows;
	}
	
	
	
	@Override
	public List<Node> findZtreeMenuNodes(){
		return sysMenuDao.findZtreeMenuNodes();
	}
	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null||id<1) {
			throw new IllegalArgumentException("Invalid Id number");
		}
		//2.查询子菜单个数
		int childCount = sysMenuDao.getChildCount(id);
		if(childCount>0) {
			throw new ServiceException("Please delete child menu first");
		}
		//3.1删除关系数据;
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//3.2删除自身信息
		int rows = sysMenuDao.deleteObject(id);
		if(rows==0) {
			throw new ServiceException("Record may not exist");
		}
		return rows;
		
		
		
	}
	
	@Cacheable(value="menuCache")
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuDao.findObjects();
	}

	@Override
	public List<SysUserMenu> findUserMenusByUserId(Integer id) {
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds);	
		return sysMenuDao.findMenusByIds(menuIds);
	}

}
