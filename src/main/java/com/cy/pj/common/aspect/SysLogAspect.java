package com.cy.pj.common.aspect;

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

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.utils.IPUtils;
import com.cy.pj.common.utils.ShiroUtils;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Aspect 注解描述的类为spring aop中的一个切面类型，此类型可以定义
 * 1.切入点(PointCut)方法(可以是多个)
 * 2.通知方法(Advice)
 * @author Administrator
 *
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
	
	@Pointcut("@annotation(com.cy.pj.common.annotation.RequiredLog)")
	public void doLogPointCut() {}
	
	@Around("doLogPointCut()")
	public Object doLogAround(ProceedingJoinPoint jp) throws Throwable{
		long t1 = System.currentTimeMillis();
		try {
			Object result=jp.proceed();
			long t2 = System.currentTimeMillis();
			log.info("The time spent executing the method is:", t2-t1);
			saveUserLog(jp,(t2-t1));
			return result;
			
		} catch (Throwable e) {
			log.error("There is an error running the method, it is:",e.getMessage());
			throw e;
		}
	}
	
	@Autowired
	private SysLogService sysLogService;
	public void saveUserLog(ProceedingJoinPoint jp,long time)throws Throwable{
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
		log.setTime(time);
		log.setCreatedTime(new Date());
		
		sysLogService.saveObject(log);
		 
	
	}
	
	
}
