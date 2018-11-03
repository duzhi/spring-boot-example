package com.daimabaike.springboot.webapp.foo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daimabaike.springboot.webapp.common.web.BaseController;
import com.daimabaike.springboot.webapp.foo.dto.BarDTO;

@Controller
public class FooController extends BaseController {

	Logger logger = LoggerFactory.getLogger(FooController.class);

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
	
	@RequestMapping("/")
	public String home1(HttpServletRequest req) {
		return "index.html";
	}
	
	@RequestMapping("/umi/hello")
	public String home(HttpServletRequest req) {
		return "/umi/hello/index.html";
	}
	
	@RequestMapping("/umi/hello/users.html")
	public String hom1e(HttpServletRequest req) {
		logger.info("*.html");
		return "/umi/hello/index.html";
	}
	
	@GetMapping("zz/{channelId}/{type}")
	public String name(BarDTO dto) {
		
		return "redirect:http://localhost:8300/bar/name/"+dto.getChannelId()+"/" + dto.getType();
	}
}
