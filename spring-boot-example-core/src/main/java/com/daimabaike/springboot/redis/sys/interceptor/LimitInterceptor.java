package com.daimabaike.springboot.redis.sys.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LimitInterceptor implements HandlerInterceptor {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		int count;
//		Object countObj = request.getSession().getAttribute("count");
//		if (countObj == null) {
//			count = 0;
//		} else {
//			count = (Integer) countObj;
//			count++;
//		}
//		request.getSession().setAttribute("count", count);
//		
		log.info("RequestURL={}", request.getRequestURL());
		
		Cookie[] cookies = request.getCookies();
		StringBuffer sb = new StringBuffer();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName() + ":" + cookie.getValue() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		
		
	//	response.setHeader("Cache-Control","no-cache");

	//	response.setDateHeader("Expires",-1);

		response.setHeader("Pragma","no-cache");


//
//		log.info("response.header.Set-Cookie:" + response.getHeader("Set-Cookie"));
		log.info("cookie is {}",sb.toString());
//		log.info("count="+count);
		return true;
	}
}
