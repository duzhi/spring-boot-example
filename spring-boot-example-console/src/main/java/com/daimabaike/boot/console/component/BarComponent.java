package com.daimabaike.boot.console.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// 小的先执行
@Order(1)
public class BarComponent implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BarComponent.class);

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 3; i++) {
			logger.info(" hello world222 at {}.", new Date());
			Thread.sleep(1000);
		}
	}

}
