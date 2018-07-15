package com.daimabaike.springboot.mybatis.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.service.UserService;

@RestController
public class UserController extends BaseController{

	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}")
	public User get(@PathVariable String id) {
		User user = userService.get(id);

		logger.info(user.toString());
		return user;
	}

}
