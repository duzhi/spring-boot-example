package com.daimabaike.console.biz.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
//@Component
// 小的先执行
@Order(1)
public class BarComponent implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BarComponent.class);

	@Override
	public void run(String... args) {
		for (int i = 0; i < 2; i++) {
			logger.info(" hello world 1 at {}.", new Date());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
