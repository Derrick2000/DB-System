package com.cy.aop;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.common.bo.PageObject;
import com.cy.sys.service.SysUserService;
import com.cy.sys.vo.SysUserDeptVo;

@SpringBootTest
public class AopTests {
	@Autowired
	private SysUserService sysUserService;
	@Test
	public void testSysUserService() {
		PageObject<SysUserDeptVo> po = sysUserService.findPageObjects("admin", 1);
		System.out.println("rowCount: "+po.getRowCount());
	}
}
