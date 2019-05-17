package com.daimabaike.biz.foo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TestFooServiceImpl extends FooServiceImpl {

	@Override
	protected void getxx(String param) {
		
		// object
		// exception
		
		
		System.out.println("testestetststststsst");
	}
}
