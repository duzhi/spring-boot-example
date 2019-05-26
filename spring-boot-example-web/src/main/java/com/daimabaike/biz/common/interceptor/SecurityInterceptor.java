package com.daimabaike.biz.common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

//	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		logger.info("RequestURL={}",request.getRequestURL());
//		logger.info("RequestURI={}",request.getRequestURI());
//		logger.info("getProtocol={}",request.getProtocol());
//		logger.info("getProtocol={}",request.getProtocol());
		

		Enumeration<String> es = request.getHeaderNames();
		
//		while( es.hasMoreElements()) {
//			String name = es.nextElement();
//			logger.info(name + ": " + request.getHeader(name));
//		}
//		Cookie[] cs = request.getCookies();
//		if(cs != null) {
//			for(Cookie c :cs ) {
//				logger.info(c.getName());
//				logger.info(c.getValue());
//				logger.info(c.getDomain());
//			}
//		}
		
		if(request.getRequestURL().indexOf(".js") > 0) {
//			P3p: CP="CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR"
		response.setHeader("P3p", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		if("login".equals(request.getParameter("login"))) {
			Cookie c = new Cookie("aaa", "DADS");
//			c.setHttpOnly(httpOnly);
			response.addCookie(c);
		}
		
		
		
		
	}
	
}
