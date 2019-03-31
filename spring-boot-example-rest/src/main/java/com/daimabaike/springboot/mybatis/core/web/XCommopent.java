package com.daimabaike.springboot.mybatis.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class XCommopent {
	@Autowired
	X1Com x1Com;
	
	@Scheduled(fixedRate = 5000)
	public void fixedRate() {
		//System.out.println("当前值：" + x1Com.js.get());
		
	}
}
