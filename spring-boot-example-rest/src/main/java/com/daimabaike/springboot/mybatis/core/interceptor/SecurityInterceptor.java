package com.daimabaike.springboot.mybatis.core.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.daimabaike.springboot.mybatis.core.web.X1Com;

@Component
@Order(10)
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	X1Com x1Com;

	ThreadLocal<Long> aa = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// System.out.println("增加1，当前值：" + x1Com.js.incrementAndGet());
		log.info("RequestURL={}", request.getRequestURL());
		aa.set(System.currentTimeMillis());

		Enumeration<String> es = request.getHeaderNames();

		while (es.hasMoreElements()) {
			String name = es.nextElement();
			log.info("{}={}", name, request.getHeader(name));
		}

		// 计算视图
		// String v = request.getParameter("v");
		// if( v!=null ) {
		// request.setAttribute("viewType", v);
		// }
		//
		// Cookie c = new Cookie("bbb", "adasd");
		// c.setHttpOnly(true);
		//
		// response.addCookie(c);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("减少1，当前值：" + x1Com.js.decrementAndGet());

		long start = aa.get();
		log.info("cost={}", System.currentTimeMillis() - start);
		aa.remove();

//		response.get
	}
}
