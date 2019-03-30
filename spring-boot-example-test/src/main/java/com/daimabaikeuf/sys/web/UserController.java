package com.daimabaikeuf.sys.web;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaikeuf.sys.model.CreateUserRequest;
import com.daimabaikeuf.sys.model.CreateUserResponse;
import com.daimabaikeuf.sys.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("create-user")
	public CreateUserResponse CreateUser(@RequestBody CreateUserRequest req) {
		
		return userService.insert(req);
		// ex, 走异常
	}

	@RequestMapping("login")
	public String login(@RequestBody CreateUserRequest req) {
		
		Cookie c = new Cookie("s","ss");
		c.setHttpOnly(true);
		
		return "";
	}
	
}
