package com.daimabaike.console.biz.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//@Component
@Order(10)
public class FooComponent implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FooComponent.class);
	@Autowired
	E1 e1;
	
	@Autowired
	E2 e2;
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info ("e1 == e2.getE1()="+(e1 == e2.getE1()));
		for (int i = 0; i < 2; i++) {
			logger.info(" hello world 2 at {}.", new Date());
			Thread.sleep(100);
			
			
			
			
		}
	}
}
