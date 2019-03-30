package com.daimabaike.springboot.redis.sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.daimabaike.springboot.redis.sys.interceptor.LimitInterceptor;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
	@Autowired
	private LimitInterceptor limitInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(limitInterceptor);
		// 排除配置
		addInterceptor.excludePathPatterns("/error");
	//	addInterceptor.excludePathPatterns("/login");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
			
		
	}

	
	
	
}
