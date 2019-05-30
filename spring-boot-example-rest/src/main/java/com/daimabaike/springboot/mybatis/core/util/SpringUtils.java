package com.daimabaike.springboot.mybatis.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware{

	static ApplicationContext ac;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ac = applicationContext;
	}

	public static <T> T getBean(String name, Class<T> c){
		return ac.getBean(name,c);
	}
	
	public static <T> T getBean(Class<T> c){
		return ac.getBean(c);
	}
}
