package com.daimabaike.console.biz.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Component
public class FooConfig {

	Logger logger = LoggerFactory.getLogger(FooConfig.class);

	@Bean
	public E1 e1() {
		logger.info("e1");
		return new E1();
	}
	
	@Bean
	public E2 e2() {
		logger.info("e2");
		E2 e2 = new E2();
		e2.setE1(e1());	// @Configuration @Component 有区别
		return e2;
	}
}
