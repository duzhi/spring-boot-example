package com.daimabaike.biz.foo.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.daimabaike.biz.foo.service.FooService;

@Service
public class FooServiceImpl implements FooService{

	@Override
	public Date foo() {
		System.out.println("foo");
		
		// 
		String param = null;
		getxx(param);
		
		return new Date();
	}
	
	protected void getxx(String param) {
		System.out.println("foo getxx");
	}
	
}
