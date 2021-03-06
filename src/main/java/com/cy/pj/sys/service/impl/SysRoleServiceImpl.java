package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;
import com.cy.pj.sys.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.参数有效性检验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("Page number is invalid");
		//2.查询总记录数并校验
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("Didn't find the record");
		//3.查询当前页记录
		int pageSize = 3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
		//4.封装查询结果并返回
		return new PageObject<>(pageCurrent,pageSize,rowCount,records);
	}

	@Override
	public int saveObject(SysRole entity,Integer[] menuIds) {
		if(entity==null)
			throw new IllegalArgumentException("The save object cannot be null");
		if(StringUtils.isEmpty(entity.getName())) 
	 		throw new IllegalArgumentException("Role name cannot be null");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("Role has to have permission");
		int rows=sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObjects(entity.getId(),menuIds);
		return rows;
	}

	@Override
	public SysRoleMenu findObjectById(Integer id) {
		//1.合法性验证
    	if(id==null||id<=0)
    		throw new IllegalArgumentException("Illegal id number");
    	//2.执行查询
    	SysRoleMenu result=sysRoleDao.findObjectById(id);
  	//3.验证结果并返回
    	if(result==null)
    		throw new ServiceException("The record may not exist");
    	return result;
    }

	@Override
	public int deleteObject(Integer id) {
		//1.验证数据的合法性
		if(id==null||id<=0)
			throw new IllegalArgumentException("Please choose first");
		//3.基于id删除关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);
        sysUserRoleDao.deleteObjectsByRoleId(id);
		   //4.删除角色自身
	    int rows=sysRoleDao.deleteObject(id);
	    if(rows==0)
	    	throw new ServiceException("The record may not exist");
		//5.返回结果
		return rows;
	}

	@Override
	public int updateObject(SysRole entity,Integer[] menuIds) {
	    	//1.合法性验证
	    	if(entity==null)
	    		throw new IllegalArgumentException("Updated object cannot be null");
	    	if(entity.getId()==null)
	    		throw new IllegalArgumentException("id cannot be null");
	    	
	    	if(StringUtils.isEmpty(entity.getName()))
	    		throw new IllegalArgumentException("Name cannot be null");
	    	if(menuIds==null||menuIds.length==0)
	    		throw new IllegalArgumentException("It has to have permission");
	    	
	    	//2.更新数据
	    	int rows=sysRoleDao.updateObject(entity);
	    	if(rows==0)
	    		throw new ServiceException("The object may not exist");
	    	sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
	    	sysRoleMenuDao.insertObjects(entity.getId(),menuIds);
	    	//3.返回结果
	    	return rows;
	  }

	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}


	
	
}
