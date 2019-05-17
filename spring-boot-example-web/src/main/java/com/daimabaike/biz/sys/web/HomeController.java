package com.daimabaike.biz.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.support.RequestContext;

@Controller
public class HomeController {

	@RequestMapping("/**/{regex2:[a-zA-Z0-9_-]+}")
	public String index() {
		
		System.out.println("index");
		
		
		return "index";
	}
}
