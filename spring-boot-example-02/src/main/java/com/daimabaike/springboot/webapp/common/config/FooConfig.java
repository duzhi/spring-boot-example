package com.daimabaike.springboot.webapp.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfig {

	Logger logger = LoggerFactory.getLogger(FooConfig.class);

	@Bean("strTest")
	public String createA() {
		logger.info("createA");
		return "strTest";
	}

}
