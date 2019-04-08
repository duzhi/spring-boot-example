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
public class HAJob {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Scheduled(fixedRate = 10000)
	@Async
	public void fixedRate() {
		logger.info("fixedRate hello world!" + "curr:" + new Date());
		
		// 异步任务
		
		// 数据库：任务n。任务完成触发事件
		
		
		// 1min级别事件
		
		// 按游戏ID 统计abcd
		
		// 
		
		// event(1);
		// 
		
		
		// 参数
		
		// 周期
		
		// Min1Event
	}
	
	
	
	
}
