package com.daimabaike.biz.foo.web;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.interceptor.ResultRewrite;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.foo.client.FooClient;
import com.daimabaike.biz.foo.service.FooService;
import com.daimabaike.biz.sys.entity.User;

@Controller
@ResultRewrite
public class FooController extends BaseController {

	Logger logger = LoggerFactory.getLogger(FooController.class);

	@Autowired
	FooService fooService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@Qualifier("ok3RestTemplate")
	private RestTemplate ok3RestTemplate;

	@RequestMapping("/void")
	@ResponseBody
	public void body() {
		return;
	}
	@RequestMapping("/empty")
	public String body2(Model model) {
		model.addAttribute("name", "asdal");
		return "test";
	}
	@RequestMapping(value = "/int")
	@ResponseBody
	public int empty() {
		return 123;
	}
	
	@Autowired
	FooClient FooClient;
	@RequestMapping(value = "/user")
	@ResponseBody
	public User ddd() {
		
		return FooClient.login();
	
	}
	@RequestMapping("/object")
	@ResponseBody
	@ResultRewrite
	public Date sss() {
		if (new Random().nextInt(10) > 5) {
			BizException be = new BizException("大于5");
			be.setCode(50001);
			throw be;
		}
		return fooService.foo();
	}

	@GetMapping("string")
	@ResponseBody
	public String name() {

		fooService.foo();
		
		logger.info("async,{},{}", restTemplate.getRequestFactory().getClass().getName(), ok3RestTemplate.getRequestFactory().getClass().getName());
		return "async";
		
	}

	@RequestMapping("/test11")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse resp) {

		java.util.Enumeration<String> hn = request.getHeaderNames();
		while (hn.hasMoreElements()) {
			String name = hn.nextElement();
			System.out.println(name + "=" + request.getHeader(name));
		}

		request.getSession(false);
		// .getServletContext();

		String body = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"utf-8\">\r\n"
				+ "<meta name=\"viewport\"\r\n"
				+ "	content=\"width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no\">\r\n"
				+ "<meta http-equiv=\"Cache-control\" content=\"no-store\">\r\n"
				+ "<meta http-equiv=\"Expires\" content=\"0\">\r\n"
				+ "<meta http-equiv=\"Pragma\" content=\"no-cache\">\r\n" + "\r\n" + "<title>Test页面</title>\r\n"
				+ "<script src=\"./a.js\"></script>\r\n" + "</head>\r\n" + "<body>\r\n" + "	<div id=\"index\">\r\n"
				+ "	test page 233 new new\r\n" + "		<a href=\"/page.html\">page</a>\r\n"
				+ "		<a href=\"/test\">Test</a>\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>";
		return body;
	}

}
