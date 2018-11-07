package com.daimabaike.springboot.mybatis.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.Result;
import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.dto.UserDto;
import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.service.UserService;

@RestController
@RequestMapping(value = "sys")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}")
	public User get(UserDto userDto) {
		User user = userService.get(userDto);

		logger.info(user.toString());
		return user;
	}

	@RequestMapping(value = "/user/for-update")
	public Result<User> forUpdate(UserDto userDto) {
		logger.info("name={}", userDto.getName());

		return userService.doBiz(userDto);
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
