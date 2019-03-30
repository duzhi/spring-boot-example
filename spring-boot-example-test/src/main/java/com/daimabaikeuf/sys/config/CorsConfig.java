package com.daimabaikeuf.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAsync
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);
	}

	@Bean("aaa")
	@Primary
	public TaskExecutor c() {
		ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
		e.setCorePoolSize(10);
		e.setMaxPoolSize(20);
		e.setQueueCapacity(100);
		e.setThreadNamePrefix("aaa-");
		return e;
	}
	
	@Bean("bbb")
	public TaskExecutor c2() {
		ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
		e.setCorePoolSize(10);
		e.setMaxPoolSize(20);
		e.setQueueCapacity(100);
		e.setThreadNamePrefix("bbb-");
		return e;
	}
	
}
