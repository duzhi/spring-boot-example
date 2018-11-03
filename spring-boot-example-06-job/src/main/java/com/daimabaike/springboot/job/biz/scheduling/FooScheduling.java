package com.daimabaike.springboot.job.biz.scheduling;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Random;

@Configuration
@EnableScheduling
public class FooScheduling {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// 固定间隔时间开始执行（方法体的时间消耗不计算）
	@Scheduled(fixedRate = 50000)
	public void fixedRate() {
		logger.info("fixedRate hello world!");
		logger.info("curr:" + new Date());
		for (int i = 0; i < 1000; i++) {
			Random z = new Random();
			new String("aa" + z.nextInt(100) + i);
			new String("bb" + z.nextInt(100) + i);
			new String("cc" + z.nextInt(100) + i);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}

	}

	// 每次执行完成后间隔指定时间开始执行
	@Scheduled(fixedDelay = 5000)
	public void fixedDelay() {
		logger.info("fixedDelay hello world!");
		logger.info("curr:" + new Date());
		for (int i = 0; i < 1000; i++) {
			Random z = new Random();
			new String("vv" + z.nextInt(100) + i);
			new String("xx" + z.nextInt(100) + i);
			new String("ww" + z.nextInt(100) + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}

	}

}
