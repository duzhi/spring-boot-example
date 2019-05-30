package com.daimabaike.springboot.mybatis.sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.daimabaike.springboot.mybatis.core.Result;
import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.service.UserBatchService;
import com.daimabaike.springboot.mybatis.sys.service.UserService;

@RestController
@RequestMapping(value = "sys")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserBatchService userBatchService;

	@RequestMapping(value = "/batch")
	public Result<String> get() {
		return Result.ok(userBatchService.doBiz() + "");
	}

	@RequestMapping(value = "/update")
	public Result<String> update() {
		return Result.ok(userService.update(new User()) + "");
	}

	@RequestMapping(value = "/user/{id}")
	public Result<User> get(User user) {
		int slp = new Random().nextInt(10) + 20;
		logger.info("slp={}",slp);
		try {
			TimeUnit.SECONDS.sleep(slp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		user = userService.get(user);
		if (user == null) {
			return Result.fail("user 不存在");
		}

		logger.info(user.toString());
		return Result.ok(user);
	}
	
	@RequestMapping(value = "/user/for-update")
	public Result<User> forUpdate(User user) {
		logger.info("name={}", user.getName());

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
	public void users(int time, HttpServletResponse response) {

		User user = new User();
		user.setId(123L);
		user.setCreateDate(new Date());
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			PrintWriter pw = response.getWriter();
			pw.println(JSONObject.toJSONString(Result.ok(user)));

			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("users t34t4t3t");
		// return Result.ok(user);
	}

	@RequestMapping("error500")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<Void> ERR500() {
		return Result.fail(50001, "500 error");
	}

	@RequestMapping("error400")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<User> dadsad() {
		return Result.fail(40001, "400 error");
	}
}
