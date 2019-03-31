package com.daimabaike.springboot.mybatis.foo.web;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BarController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "bar")
	@ResponseBody
	public String ss(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		StringBuffer sb = new StringBuffer();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName() + ":" + cookie.getValue() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}

		log.info("cookie is {}", sb.toString());
		return "bar" + new Date();
	}
}
