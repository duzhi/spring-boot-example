package com.daimabaike.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daimabaike.webflux.dao.UserRepository;
import com.daimabaike.webflux.entity.User;

import reactor.core.publisher.Mono;

/**
 * Mono ：单，Flux ：流
 *
 */
@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	UserRepository userRepository;
	
	@GetMapping("/page")
	public Mono<String> page(Model model) {
		logger.info("page");
		model.addAttribute("name", "jack");
		String path = "page";
		return Mono.create(monoSink -> monoSink.success(path));
	}
	@GetMapping("/page2")
	public Mono<String> page2(Model model) {
		logger.info("page");
		model.addAttribute("name", "jim");
		
		Mono<User> m = userRepository.findByName("jim");
		model.addAttribute("user", m.block());
		
		return Mono.just("page");
	}
	
	@GetMapping("/page3")
	public String page3(Model model) {
		logger.info("page");
		model.addAttribute("name", "kusl");
		return "page";
	}
}
