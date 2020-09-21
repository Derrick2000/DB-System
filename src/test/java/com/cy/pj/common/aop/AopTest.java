package com.cy.pj.common.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.pojo.SysUserDept;
import com.cy.pj.sys.service.SysUserService;

@SpringBootTest
public class AopTest {
	
	@Autowired
	private SysUserService userService;
	
	@Test
	public void testSysUserService() {
		PageObject<SysUserDept> po = userService.findPageObjects("admin", 1);
		System.out.println("rowCount:"+po.getRowCount());
	}
}
