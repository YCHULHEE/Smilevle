package com.smilevle.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExcuteTimeInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		String reqUri = request.getRequestURI();
		System.out.println("reqUri" + reqUri);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long excuteTime = endTime - startTime;
		
		request.setAttribute("excuteTime", excuteTime);
		System.out.println("메서드 실행 시간은?" + excuteTime + "ms");
		
	}
}
