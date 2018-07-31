package com.daimabaike.springboot.job.biz.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class FooScheduling {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// 固定间隔时间开始执行（方法体的时间消耗不计算）
	@Scheduled(fixedRate = 3*10)
	public void fixedRate() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		logger.info("fixedRate hello world!");
	}
	
	// 每次执行完成后间隔指定时间开始执行
	@Scheduled(fixedDelay = 5000)
	public void fixedDelay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		logger.info("fixedDelay hello world!");
	}

}
