package com.cy.pj.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class SysExceptionAspect {
	/**此方法可以作为一个异常监控方法*/
	@AfterThrowing(pointcut = "bean(*ServiceImpl)",throwing = "ex")
	public void handleException(JoinPoint jp,Throwable ex) {
		//通过连接点获取目标对象类型
		Class<?> targetClass=jp.getTarget().getClass();
		String className=targetClass.getName();
		//通过连接点获取方法签名对象
		MethodSignature s=(MethodSignature)jp.getSignature();
		String methodName=s.getName();//获取目标方法名
		String targetClassMethod=className+"."+methodName;
		log.error("{}'exception msg is  {}",targetClassMethod,ex.getMessage());
	}
}