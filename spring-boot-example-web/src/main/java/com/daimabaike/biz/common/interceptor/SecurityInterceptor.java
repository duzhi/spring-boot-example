package com.daimabaike.biz.common.interceptor;

import java.util.Enumeration;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

	DelayQueue<RunnableScheduledFuture<Void>> dq = new DelayQueue<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		dq.add(new RunnableScheduledFuture<Void>() {

			@Override
			public void run() {
				
			}

			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}

			@Override
			public Void get() throws InterruptedException, ExecutionException {
				return null;
			}

			@Override
			public Void get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				return null;
			}

			@Override
			public long getDelay(TimeUnit unit) {
				return 0;
			}

			@Override
			public int compareTo(Delayed o) {
				return 0;
			}

			@Override
			public boolean isPeriodic() {
				return false;
			}
			
		});
		
		log.info("RequestURL={}",request.getRequestURL());

		Enumeration<String> es = request.getHeaderNames();
		
		while( es.hasMoreElements()) {
			String name = es.nextElement();
			System.out.println(name + ": " + request.getHeader(name));
		
		}
		
		// 计算视图
//		String v = request.getParameter("v");
//		if( v!=null ) {
//			request.setAttribute("viewType", v);
//		}
//		
//        Cookie c = new Cookie("bbb", "adasd");
//        c.setHttpOnly(true);
//        
//		response.addCookie(c);
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
