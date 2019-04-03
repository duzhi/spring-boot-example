package com.daimabaike.springboot.mybatis.foo.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "link")
	public String ss(String q) {

		return "redirect:http://b.daimabaike.com:8090/foo/a/1.html";

	}

	@RequestMapping(value = "a/2.html")
	@ResponseBody
	public String ss2(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int count;
		Object countObj = request.getSession().getAttribute("count");
		if (countObj == null) {
			count = 0;
		} else {
			count = (Integer) countObj;
			count++;
		}
		request.getSession().setAttribute("count", count);

		Cookie[] cookies = request.getCookies();
		StringBuffer sb = new StringBuffer();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName() + ":" + cookie.getValue() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		
		
		log.info("response.header.Set-Cookie:" + response.getHeader("Set-Cookie"));
		log.info("cookie is {}",sb.toString());
		return count + "," + new Date();

	}
	
	@RequestMapping("a")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
//		int count;
//		Object countObj = request.getSession().getAttribute("count");
//		if (countObj == null) {
//			count = 0;
//			Cookie c1 = new Cookie("_c1","a123");
//			c1.setMaxAge(24 * 3600);
//			c1.setPath("/");
//			response.addCookie(c1);
//			log.info("cookie c1 is {}", c1);
//		} else {
//			count = (Integer) countObj;
//			count++;
//		}
//		request.getSession().setAttribute("count", count);

		model.addAttribute("name", "zs");		
		model.addAttribute("count", 1);
		return "a";
	}
}
