package com.cy.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.sys.dao.SysLogDao;
import com.cy.sys.entity.SysLog;

@SpringBootTest
public class SysLogDaoTests {
	@Autowired
	private SysLogDao syslogDao;
	
	@Test
	public void testGetRowCount() {
		int rows = syslogDao.getRowCount("admin");
		System.out.println("rows="+rows);
	}
	
	@Test
	public void testFindPageObject() {
		List<SysLog> list = syslogDao.findPageObjects("admin", 0, 3);
		for(SysLog log:list) {
			System.out.println(log);
		}
	}
}
