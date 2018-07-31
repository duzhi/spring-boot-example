package com.daimabaike.springboot.webapp.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfiguration {

	Logger logger = LoggerFactory.getLogger(FooConfiguration.class);

	@Bean("strTest")
	public String createA() {
		logger.info("createA");
		return "strTest";
	}

}
