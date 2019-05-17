package com.daimabaike.console.biz.scheduling;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class FooScheduling {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 注意下面两个方法会干扰，不能并行执行，A 方法在执行，则 B 方法会等待，待执行任务会加入队列
	 */
	
	/**
	 * 固定间隔时间开始执行（方法体的时间消耗不计算）
	 */
	@Scheduled(fixedRate = 10000)
	@Async
	public void fixedRate() {
		logger.info("fixedRate hello world!" + "curr:" + new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * 每次执行完成后间隔指定时间开始执行
	 */
	@Scheduled(fixedDelay = 10000)
	@Async
	public void fixedDelay() {
		logger.info("fixedDelay hello world!" + "curr:" + new Date());
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		
		// 多个任务，
		
	}

}
