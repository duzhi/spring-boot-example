package com.daimabaike.webflux.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.daimabaike.webflux.controller.EchoHandler;

@Configuration
public class InitConfig {

	private static final Logger logger = LoggerFactory.getLogger(InitConfig.class);

	@Bean
	public RouterFunction<ServerResponse> create(EchoHandler echoHandler) {
		logger.info("RouterFunction");
		return RouterFunctions.route(RequestPredicates.GET("/echo"), echoHandler::echo);
	}
}
