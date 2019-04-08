package com.daimabaike.biz.foo.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.daimabaike.biz.foo.event.OrderSuccEvent;
import com.daimabaike.biz.foo.event.OtherEvent;

@EnableRetry
@Service
public class BarService{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	// EventService eventService;

	@Retryable // (exclude= {Exist.class})
	public void order() {

		logger.info("start");
		if (new Random().nextInt(10) < 15) {

			
			throw new RetryException("123");

		}
		// return null;

	}

	@Recover
	public void recover(RetryException e) {
		//System.out.println(e.getMessage());
		applicationContext.publishEvent(new OtherEvent("other evetnt"));
	}

	@Autowired
	private ApplicationContext applicationContext;

	public String biz() {

		logger.info("biz");

		// db save event => 做成 service
		// goto
		applicationContext.publishEvent(new OrderSuccEvent("order123"));

		// 本地消息
		return "biz";

	}


}
