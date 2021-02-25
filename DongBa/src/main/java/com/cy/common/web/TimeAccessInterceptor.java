package com.cy.common.web;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.cy.common.exception.ServiceException;

public class TimeAccessInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("==preHandler==");
		LocalDateTime localDateTime = LocalDateTime.now();
		int hour = localDateTime.getHour();
		System.out.println("hour="+hour);
		if(hour < 8 && hour > 2 ) {
			throw new ServiceException("Please log in between 8:00 - 2:00");
		}
		return true;
	}
}
