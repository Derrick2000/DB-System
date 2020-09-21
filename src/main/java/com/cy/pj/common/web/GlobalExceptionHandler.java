package com.cy.pj.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.cy.pj.common.vo.JsonResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(
				RuntimeException e){
	    	e.printStackTrace();
			
		    return new JsonResult(e);//封装
	   }
	
	
	@ExceptionHandler(ShiroException.class) 
	public JsonResult doHandleShiroException(
			ShiroException e) {
		JsonResult r=new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException) {
			r.setMessage("Username does not exist");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("Account has been forbiddened");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("Incorrect password");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("Not authorized");
		}else {
			r.setMessage("System is in maintainence");
		}
		e.printStackTrace();
		return r;
	}
}
