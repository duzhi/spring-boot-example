package com.daimabaike.biz.foo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.foo.service.FooService;

@Controller
public class FooController extends BaseController {

	Logger logger = LoggerFactory.getLogger(FooController.class);
	
	@Autowired
	FooService fooService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest req, HttpServletResponse resp) {
		
		String body = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<meta name=\"viewport\"\r\n" + 
				"	content=\"width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no\">\r\n" + 
				"<meta http-equiv=\"Cache-control\" content=\"no-store\">\r\n" + 
				"<meta http-equiv=\"Expires\" content=\"0\">\r\n" + 
				"<meta http-equiv=\"Pragma\" content=\"no-cache\">\r\n" + 
				"\r\n" + 
				"<title>Test页面</title>\r\n" + 
				"<script src=\"./a.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div id=\"index\">\r\n" + 
				"	test page 233 new new\r\n" + 
				"		<a href=\"/page.html\">page</a>\r\n" + 
				"		<a href=\"/test\">Test</a>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		resp.addHeader("Last-Modified", "Thu, 04 Oct 2018 09:01:58 GMT");
		return body;
	}
	
	@GetMapping("foo/async")
	@ResponseBody
	public String name() {
		
		fooService.foo();
		logger.info("async");
		return "async";
	}
}
