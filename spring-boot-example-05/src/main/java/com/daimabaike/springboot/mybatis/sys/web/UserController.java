package com.daimabaike.springboot.mybatis.sys.web;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.entity.Result;
import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.service.UserService;

@RestController
@RequestMapping(value = "sys")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}")
	public User get(@PathVariable String id) throws IllegalArgumentException, IllegalAccessException {
		User user = userService.get(id);

		Field tof = null;
		tof.set(this, 111);
		
		
		logger.info(user.toString());
		return user;
	}

	@RequestMapping(value = "/user/for-update")
	public Result<User> forUpdate(User user) {
		logger.info("name={}", user.getName());

		Result<User> r = this.validate(user);
		if (r != null) {
			return r;
		}

		return userService.doBiz(user);
	}

	@RequestMapping(value = "/user/test-result")
	public Result<String> testResult() {
		return Result.ok("test");
	}

	// {MediaType.TEXT_HTML_VALUE,
	@RequestMapping(value = "/user/test", produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello w", HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping("users")
	public Result<User> users() {
		
		User user = new User();
		user.setId("123");
		user.setId("zhanghan");
		
		
		return Result.ok(user);
	}
	
}
