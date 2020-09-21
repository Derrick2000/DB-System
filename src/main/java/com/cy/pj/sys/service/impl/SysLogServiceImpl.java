package com.cy.pj.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	@Override
	public PageObject<SysLog> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1) {
			throw new IllegalArgumentException("Current page number is incorrent");
		}
		int pageSize = 5;
		//设置查询位置以及页面大小
		Page<SysLog> page = PageHelper.startPage(pageCurrent,pageSize);
		//查询当前页数据
		List<SysLog> records = sysLogDao.findPageObjects(name);
		return new PageObject<>(pageCurrent,pageSize,(int)page.getTotal(),records);	
	}
	
	@RequiresPermissions("sys:log:delete")
	@Override
	public int deleteObjects(Integer... ids) {
		if(ids==null||ids.length==0) {
			throw new IllegalArgumentException("Please choose the next one");
		}
		int rows;
		try {
			rows=sysLogDao.deleteObjects(ids);
		}catch(Throwable e) {
			e.printStackTrace();
			throw new ServiceException("The system is down, try again later...");
		}
		
		if(rows==0) {
			throw new ServiceException("The record may not exist");
		}
		return rows;
		
	}

	//若将此业务方法参与到其他事务中执行，传播特性为Propagation.REQUIRED
	//若将此业务方法始终运行在一个独立事务中，传播特性为Propagation.REQUIRED_NEW
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Async //运行在spring框架提供的一个线程中
	@Override
	public void saveObject(SysLog entity) {
		String tName=Thread.currentThread().getName();
		//System.out.println("SysLogService.saveObject.thread.name="+tName);
		sysLogDao.insertObject(entity);
		
		
	}
}
