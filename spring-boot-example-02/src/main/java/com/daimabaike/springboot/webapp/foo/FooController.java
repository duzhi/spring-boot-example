package com.daimabaike.springboot.webapp.foo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	Logger logger = LoggerFactory.getLogger(FooController.class);

	@Autowired
	private String strTest;

	@RequestMapping()
	public String home() {
		return String.format("hello world");
	}

	@RequestMapping("foo")
	public String foo() {
		logger.info("strTest = {}", strTest);
		return String.format(" hello world at %s.", new Date());
	}

}
