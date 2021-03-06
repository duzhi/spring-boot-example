package com.daimabaike.console.biz.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//@Component
@Order(10)
public class FooComponent implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FooComponent.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		for (int i = 0; i < 2; i++) {
			logger.info(" hello world 2 at {}.", new Date());
			Thread.sleep(100);
			
		}
	}
}
