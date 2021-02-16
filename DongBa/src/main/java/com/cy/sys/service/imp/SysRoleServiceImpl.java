package com.cy.sys.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.bo.PageObject;
import com.cy.common.exception.ServiceException;
import com.cy.common.vo.CheckBox;
import com.cy.sys.dao.SysRoleDao;
import com.cy.sys.dao.SysRoleMenuDao;
import com.cy.sys.dao.SysUserRoleDao;
import com.cy.sys.entity.SysRole;
import com.cy.sys.pojo.SysRoleMenu;
import com.cy.sys.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("Invalid page number");
		}
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount == 0) {
			throw new ServiceException("No corresponding records");
		}
		int pageSize = 5;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysRole> records = sysRoleDao.findPageObject(name, startIndex, pageSize);
		return new PageObject<SysRole>(pageCurrent,pageSize,rowCount,records);
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		if(entity == null) {
			throw new IllegalArgumentException("Saved Object cannot be null");
		}
		if(StringUtils.isEmpty(entity.getName())) {
			throw new IllegalArgumentException("Role name cannot be null");
		}
		if(menuIds == null || menuIds.length == 0) {
			throw new ServiceException("Role has to have permissions");
		}
		int rows = sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		return rows;
	}

	@Override
	public SysRoleMenu findObjectById(Integer id) {
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("Illegal id number");
		}
		SysRoleMenu result = sysRoleDao.findObjectById(id);
		if(result == null) {
			throw new ServiceException("The record may not exist");
		}
		return result;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("Please choose first");
		}
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);
		int rows = sysRoleDao.deleteObject(id);
		if(rows == 0) {
			throw new ServiceException("The record may not exist");
		}
		return rows;
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		if(entity == null) {
			throw new IllegalArgumentException("Updated object cannot be null");
		}
		if(entity.getId() == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		if(StringUtils.isEmpty(entity.getName())) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		if(menuIds == null || menuIds.length == 0) {
			throw new IllegalArgumentException("It has to have permission");
		}
		
		int rows = sysRoleDao.updateObject(entity);
		if(rows == 0) {
			throw new ServiceException("The object may not exist");
		}
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		return rows;
	}

	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}
	
}
