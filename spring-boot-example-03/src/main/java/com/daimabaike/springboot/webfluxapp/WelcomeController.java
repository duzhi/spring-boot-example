package com.daimabaike.springboot.webfluxapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

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
		ThreadUtils.print();
		return Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				logger.info("welcome accept");
				ThreadUtils.print();
				stringMonoSink.success("Hello World:" + new Date());
			}
		});
	}

	@GetMapping("/w")
	public Flux<String> welcome2() {
//		return Flux.create(new Consumer<FluxSink<String>>() {
//			@Override
//			public void accept(FluxSink<String> stringFluxSink) {
//				stringFluxSink.next("Hello World:" + new Date()).complete();
//			}
//		});
		
		return Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				stringMonoSink.success("Hello World 1:" + new Date());
			}
		}).concatWith(Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				stringMonoSink.success("Hello World 2:" + new Date());
			}
		}));
	}

	@GetMapping("/hello")
	public Mono<String> hello(String name) {
		return Mono.create(new Consumer<MonoSink<String>>() {
			@Override
			public void accept(MonoSink<String> stringMonoSink) {
				stringMonoSink.success("hello, " + name);
			}
		});
	}

	@GetMapping("/hi/{name}")
	public Flux<List<String>> hi(@PathVariable String name) {
		return Flux.create(new Consumer<FluxSink<List<String>>>() {
			@Override
			public void accept(FluxSink<List<String>> stringFluxSink) {

				List<String> stringList1 = new ArrayList<String>();
				stringList1.add("hi 1, " + name);

				List<String> stringList2 = new ArrayList<String>();
				stringList2.add("hi 2, " + name);

				stringFluxSink.next(stringList1).next(stringList2).complete();
			}
		});
	}

}
