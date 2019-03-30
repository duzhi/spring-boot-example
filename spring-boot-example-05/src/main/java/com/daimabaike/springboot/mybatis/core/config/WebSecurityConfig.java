package com.daimabaike.springboot.mybatis.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.daimabaike.springboot.mybatis.core.interceptor.LimitInterceptor;
import com.daimabaike.springboot.mybatis.core.interceptor.SecurityInterceptor;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
	@Autowired
	private SecurityInterceptor securityInterceptor;
	@Autowired
	private LimitInterceptor limitInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(securityInterceptor);
		// 排除配置
		addInterceptor.excludePathPatterns("/error");
	//	addInterceptor.excludePathPatterns("/login");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
		
		
		InterceptorRegistration addInterceptor2 = registry.addInterceptor(limitInterceptor);
		addInterceptor2.addPathPatterns("/sys/users");
		
	}

	
	
	
}
