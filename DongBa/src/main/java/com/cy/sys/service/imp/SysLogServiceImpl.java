package com.cy.sys.service.imp;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.common.bo.PageObject;
import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysLogDao;
import com.cy.sys.entity.SysLog;
import com.cy.sys.service.SysLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("Invalid Page Number");
		
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount == 0) {
			throw new ServiceException("No records in System");
		}
		int pageSize = 5;
		Page<SysLog> page = PageHelper.startPage(pageCurrent.intValue(),pageSize);
		List<SysLog> records = sysLogDao.findPageObjects(username);
		return new PageObject<>(pageCurrent,pageSize,rowCount,records);
//		int startIndex = (pageCurrent-1) * pageSize;
//		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
//		
//		PageObject<SysLog> pageObject = new PageObject<>();
//		pageObject.setPageCurrent(pageCurrent);
//		pageObject.setPageSize(pageSize);
//		pageObject.setRowCount(rowCount);
//		pageObject.setRecords(records);
//		pageObject.setPageCount((rowCount-1)/pageSize+1);
//		
//		return pageObject;
	}

	@RequiresPermissions("sys:log:delete")
	@Override
	public int deleteObjects(Integer... ids) {
		if(ids == null || ids.length == 0) {
			throw new IllegalArgumentException("Please choose one");
		}
		int rows;
		try {
			rows = sysLogDao.deleteObjects(ids);
		}catch(Throwable e){
			e.printStackTrace();
			throw new ServiceException("System is down");
		}
		if(rows == 0) {
			throw new ServiceException("Record may not exist");
		}
		return rows;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)//独立事务
	@Async //运行在spring框架提供的一个线程中
	@Override
	public void saveObject(SysLog entity) {
//		String tName=Thread.currentThread().getName();
//		System.out.println("SysLogService.saveObject.thread.name="+tName);
		sysLogDao.insertObject(entity);
	}
	
}
