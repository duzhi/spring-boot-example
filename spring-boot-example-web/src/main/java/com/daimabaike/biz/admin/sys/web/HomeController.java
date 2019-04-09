package com.daimabaike.biz.admin.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/**/{regex2:[a-zA-Z0-9_-]+}")
	public String index() {
		
		System.out.println("index");
		
		return "index";
	}
}
