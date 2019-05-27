package com.daimabaike.biz.sys.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.biz.common.PageInfo;
import com.daimabaike.biz.common.interceptor.ResultRewrite;
import com.daimabaike.biz.sys.entity.User;

@RestController
@RequestMapping("admin/sys")
public class UserController {

	/**
	 * query sql 
	 * @return
	 */
	@GetMapping("user/select")
	public PageInfo<User> select() {
		return null;
	}
	
	/**
	 * get 
	 * @return
	 */
	@GetMapping("user/get")
	@ResultRewrite
	public User get(@RequestParam String id) {
		return new User();
	}
	
	@PostMapping("user/delete")
	public User delete() {
		return null;
	}
	
	@PostMapping("user/save")
	public User save() {
		return null;
	}
	
	//XXX
	@PostMapping("user/xxx")
	public User xxxx() {
		return null;
	}
	
}
