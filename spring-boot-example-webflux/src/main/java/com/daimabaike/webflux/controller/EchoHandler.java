package com.daimabaike.webflux.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class EchoHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);

	public Mono<ServerResponse> echo(ServerRequest request) {

		logger.info("echo");

//		Mono<String> a = Mono.create(monoSink -> monoSink.success("echo:" + new Date()));

		Mono<String> a = Mono.just("Mono.just echo:" + new Date());
		
		return ServerResponse.ok().body(a, String.class);

	}

}