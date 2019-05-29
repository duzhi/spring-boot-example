package com.daimabaike.biz.foo.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.daimabaike.biz.foo.service.FooService;

@Service
public class FooServiceImpl implements FooService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Date foo() {
		logger.info("FooServiceImpl foo");

		return new Date();
	}

}
