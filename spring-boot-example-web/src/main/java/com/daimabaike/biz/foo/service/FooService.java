package com.daimabaike.biz.foo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class FooService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async
	public void foo() {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		
		logger.info("foo");
		
	}
	
}
