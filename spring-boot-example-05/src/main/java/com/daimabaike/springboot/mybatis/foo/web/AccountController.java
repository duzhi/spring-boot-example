package com.daimabaike.springboot.mybatis.foo.web;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.DynamicDataSource;
import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.foo.entity.Account;
import com.daimabaike.springboot.mybatis.foo.service.AccountService;

@RestController
@RequestMapping(value = "account")
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/{id}")
	public Account get(@PathVariable BigInteger id){

		try {
			//
			DynamicDataSource.set("ds2");
			
			logger.info("id={}", id);
			return accountService.get(id);
		} finally {
			DynamicDataSource.clear();
		}
	}
	
}
