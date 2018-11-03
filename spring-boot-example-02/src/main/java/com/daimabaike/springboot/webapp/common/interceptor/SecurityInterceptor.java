package com.daimabaike.springboot.webapp.common.interceptor;

import java.util.Arrays;

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

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.info("getRequestURL={}",request.getRequestURL());
		
		// 计算视图
		
		String v = request.getParameter("v");
		if( v!=null ) {
			request.setAttribute("viewType", v);
		}
		
		Cookie[] cookies = request.getCookies();
        log.info("cookies info:" + Arrays.toString(cookies));
 
		//
//		get(TOKEN) = 
//		if (null) {
//			return ;	
//		}
		
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod m = (HandlerMethod) handler;
//
//			SecurityPermission sp = m.getMethodAnnotation(SecurityPermission.class);
//
//			for (String permission : sp.value()) {
//				log.info(permission);
//			}
//			
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//
//			response.getWriter().write("{\"code\":\"403\",\"msg\":\"403 For\"}");
//			return false;
//		}
        Cookie c = new Cookie("bbb", "adasd");
        c.setHttpOnly(true);
        
		response.addCookie(c);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		if("login".equals(request.getParameter("login"))) {
			Cookie c = new Cookie("aaa", "DADS");
//			c.setHttpOnly(httpOnly);
			response.addCookie(c);
//			response.de
//			response.
		}
	}
	
}
