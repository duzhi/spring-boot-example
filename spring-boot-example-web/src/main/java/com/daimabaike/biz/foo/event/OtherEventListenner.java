package com.daimabaike.biz.foo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OtherEventListenner implements ApplicationListener<OtherEvent>{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Async
	public void onApplicationEvent(OtherEvent event) {
		logger.info((String)event.getSource());
	}
	
}
