package com.daimabaike.webflux.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Mono ：单，Flux ：流
 *
 */
@RestController
public class WelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/")
	public Mono<String> welcome() {
		logger.info("welcome");
		return Mono.create(stringMonoSink ->
				stringMonoSink.success("Hello World:" + new Date()));
	}
	
	@GetMapping("/just")
	public Mono<String> just() {
		logger.info("just");
		return Mono.just("Hello World:" + new Date());
	}

	@GetMapping("/flux")
	public Flux<Object> flux() {
		return Mono.create(stringMonoSink -> stringMonoSink.success("Hello World 1:" + new Date()))
				.concatWith(Mono.create(stringMonoSink -> stringMonoSink.success("Hello World 2:" + new Date())));
	}
	
	@GetMapping("/fluxjust")
	public Flux<String> fluxjust() {
		
		
		
		return Mono.just("Hello World 1:" + new Date()).concatWith(Mono.just("Hello World 2:" + new Date()));
	}

	@GetMapping("/hi/{name}")
	public Flux<List<String>> hi(@PathVariable String name) {
		return Flux.create(stringFluxSink -> {

			List<String> stringList1 = new ArrayList<String>();
			stringList1.add("hi 1, " + name);

			List<String> stringList2 = new ArrayList<String>();
			stringList2.add("hi 2, " + name);

			stringFluxSink.next(stringList1).next(stringList2).complete();
		});
	}

	@GetMapping("/hi2/{name}")
	public Flux<String> hi2(@PathVariable String name) {
		return Flux.create(stringFluxSink -> stringFluxSink.next("hi 1, " + name).next("hi 2, " + name).complete());
	}
}
