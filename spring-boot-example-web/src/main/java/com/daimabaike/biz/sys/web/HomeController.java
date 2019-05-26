package com.daimabaike.biz.sys.web;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

//	@RequestMapping("/**/{regex2:[a-zA-Z0-9_-]+}")
	public String index() {
		
//		System.out.println("index");
		
		return "index";
	}
}
