package com.daimabaikeuf.sys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async//("bbb")
public class XAsyncService {

	Logger logger = LoggerFactory.getLogger(XAsyncService.class);
	public void sss() {
		
		logger.info("do sm");

	}
	
}
