package com.daimabaike.biz.foo.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@EnableRetry
@Service
public class BarService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Retryable//(exclude= {Exist.class})
	public String order(){
		
		logger.info("start");
		if(new Random().nextInt(10) < 15) {
		
			throw new RuntimeException("123");
		
		}
		return null;
		
	}
	
	
}
