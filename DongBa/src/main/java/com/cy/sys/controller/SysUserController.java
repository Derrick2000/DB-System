package com.cy.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.sys.pojo.SysUser;
import com.cy.sys.service.SysUserService;

@RequestMapping("/user/")
@RestController
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}
	
	@RequestMapping("doLogin")
	public JsonResult doLogin(String username,String password,boolean isRememberMe) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token  = new UsernamePasswordToken(username,password);
		token.setRememberMe(isRememberMe);
		subject.login(token);
		return new JsonResult("login success");
	}
	
	@RequestMapping("doUpdatePassword")
	public JsonResult doUpdatePassword(String pwd,String newPwd,String cfgPwd) {
		sysUserService.updatePassword(pwd,newPwd,cfgPwd);
		return new JsonResult("Password updated");
	}
	
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysUserService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysUser entity,Integer[]roleIds) {
		sysUserService.updateObject(entity,roleIds);
		return new JsonResult("updated");
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysUser entity,Integer[]roleIds) {
		sysUserService.saveObject(entity,roleIds);
		return new JsonResult("saved");
	}
	
	@RequestMapping("doValidById")
	public JsonResult doValidById(Integer id,Integer valid) {
		sysUserService.validById(id,valid);
		return new JsonResult("updated");
	}
}
