package com.cy.common.aspect;

import org.aspectj.lang.Signature;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.utils.IPUtils;
import com.cy.common.utils.ShiroUtils;
import com.cy.sys.entity.SysLog;
import com.cy.sys.service.SysLogService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class SysLogAspect {

	@Pointcut("@annotation(com.cy.common.annotation.RequiredLog)")
	public void logPointCut() {}
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
		long t1 = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			long t2 = System.currentTimeMillis();
			saveUserLog(joinPoint,(t2-t1));
			return result;
			
		}catch(Throwable e) {
			throw e;
		}
		
	}
	@Autowired
	private SysLogService sysLogService;
	private void saveUserLog(ProceedingJoinPoint jp, long l) throws Throwable {
		String ip = IPUtils.getIpAddr();
		String username=ShiroUtils.getUsername();
		Class<?> targetClass=jp.getTarget().getClass();
		MethodSignature ms=(MethodSignature)jp.getSignature();
		String methodName=ms.getName();
		Method targetMethod=targetClass.getMethod(methodName, ms.getParameterTypes());
		RequiredLog requiredLog=targetMethod.getAnnotation(RequiredLog.class);
		
		String operation="operation";
		if(requiredLog!=null) {
			operation=requiredLog.value();
		}
		String method=targetClass.getName()+"."+methodName;
		//String params=Arrays.toString(jp.getArgs()); //json format is better
		String params=new ObjectMapper().writeValueAsString(jp.getArgs());
		SysLog log=new SysLog();
		log.setIp(ip);
		log.setUsername(username);
		log.setOperation(operation);
		log.setMethod(method);
		log.setParams(params);
		log.setTime(l);
		log.setCreatedTime(new Date());
		
		sysLogService.saveObject(log);
	}
}
