package com.daimabaike.springboot.mybatis.foo.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.foo.entity.Account;
import com.daimabaike.springboot.mybatis.foo.mapper.AccountMapper;

@Service
public class AccountService extends BaseService<AccountMapper,Account,BigInteger>{

	
	
}
