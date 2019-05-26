package com.daimabaike.biz.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.daimabaike.biz.common.interceptor.ResultRewriteInterceptor;

@Configuration
public class FooConfig implements WebMvcConfigurer{

	Logger logger = LoggerFactory.getLogger(FooConfig.class);
	@Autowired
	private ResultRewriteInterceptor resultRewriteInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(resultRewriteInterceptor);
		// 排除配置
//		addInterceptor.excludePathPatterns("/error");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}
}
