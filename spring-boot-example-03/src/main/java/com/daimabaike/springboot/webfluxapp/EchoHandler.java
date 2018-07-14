package com.daimabaike.springboot.webfluxapp;

import java.util.Date;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@Component
public class EchoHandler {

	public Mono<ServerResponse> echo(ServerRequest request) {

		Mono<String> a = Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				stringMonoSink.success("Hello World xxx:" + new Date());
			}
		});

		return ServerResponse.ok().body(a, String.class);
	}

}