package com.cy.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.vo.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
	
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e) {
		JsonResult r = new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException) {
			r.setMessage("Account does not exist");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("This account has been disabled");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("Incorrect password");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("Not authorized");
		}else {
			r.setMessage("System in maintainence");
		}
		e.printStackTrace();
		return r;
		
	}
}
