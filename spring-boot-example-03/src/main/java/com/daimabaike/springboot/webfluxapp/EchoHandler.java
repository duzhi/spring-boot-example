package com.daimabaike.springboot.webfluxapp;

import java.util.Date;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@Component
public class EchoHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	public Mono<ServerResponse> echo(ServerRequest request) {

		logger.info("echo");
		ThreadUtils.print();
		
		Mono<String> a = Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				logger.info("echo accept");
				ThreadUtils.print();
				stringMonoSink.success("Hello World xxx:" + new Date());
			}
		});
		return ServerResponse.ok().body(a, String.class);
	}

}