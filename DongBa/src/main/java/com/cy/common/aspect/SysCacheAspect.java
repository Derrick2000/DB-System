package com.cy.common.aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysCacheAspect {
	
	private Map<String,Object> cache = new ConcurrentHashMap<>();
	
	@Pointcut("@annotation(com.cy.common.annotation.RequiredCache)")
	public void doCache() {}
	
	@Pointcut("@annotation(com.cy.common.annotation.ClearCache)")
	public void doClear() {}
	
	@AfterReturning("doClear()")
	public void doClearCache() {
		cache.clear();
	}
	
	@Around("doCache()")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object result = cache.get("deptKey");
		if(result != null) {
			return result;
		}
		result = jp.proceed();
		cache.put("deptKey", result);
		return result;
	}
}
