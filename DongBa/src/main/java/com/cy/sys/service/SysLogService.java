package com.cy.sys.service;



import com.cy.common.bo.PageObject;
import com.cy.sys.entity.SysLog;

public interface SysLogService {
	PageObject<SysLog> findPageObjects(String username, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	void saveObject(SysLog entity);
}
