package com.cy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.common.bo.PageObject;
import com.cy.sys.entity.SysLog;
import com.cy.sys.service.SysLogService;

@SpringBootTest
public class SysLogServiceTests {
	
	@Autowired
	private SysLogService sysLogService;
	@Test
	public void testFindPageObjects() {
		PageObject<SysLog> pageObject = sysLogService.findPageObjects("admin", 1);
		System.out.println(pageObject);
	}
	
}
