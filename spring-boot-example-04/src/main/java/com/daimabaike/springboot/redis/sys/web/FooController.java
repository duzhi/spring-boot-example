package com.daimabaike.springboot.redis.sys.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "foo")
public class FooController {


	@RequestMapping(value = "a/1.html")
	@ResponseBody
	public String ss(String q) {
		
		return "page " + new Date();
		
	}
}
