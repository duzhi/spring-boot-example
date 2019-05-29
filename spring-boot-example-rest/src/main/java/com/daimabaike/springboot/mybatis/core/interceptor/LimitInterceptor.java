package com.daimabaike.springboot.mybatis.core.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.daimabaike.springboot.mybatis.core.Result;
import com.google.common.util.concurrent.RateLimiter;

@Order(1)
@Component
public class LimitInterceptor implements HandlerInterceptor{

    private RateLimiter limiter = RateLimiter.create(0.1);
   
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if( limiter.tryAcquire()) {
			return true;
		}
		
		try {
			System.out.println("liuliang error");
			PrintWriter pw=	response.getWriter();
			pw.println(JSONObject.toJSONString(Result.fail(40100, "liuliang error")));
			

			
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LimitInterceptor.postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LimitInterceptor.afterCompletion");
	}
}
