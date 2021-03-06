package com.daimabaike.biz.foo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderTotalListener implements ApplicationListener<OrderSuccEvent>{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async
	@Override
	public void onApplicationEvent(OrderSuccEvent event) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
		}
		
		logger.info((String)event.getSource());
		
		
	}

}
