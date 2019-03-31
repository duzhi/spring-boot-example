package com.daimabaike.springboot.redis.sys.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component("dsdada")
public class XKeyGenerator implements KeyGenerator{

	@Override
	public Object generate(Object target, Method method, Object... params) {
		
		System.out.println("XKeyGenerator.generate(...)");
		
		System.out.println(target);
		System.out.println(method);
		System.out.println(params);
		return "test";
	}

}
