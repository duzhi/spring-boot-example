package com.daimabaike.springboot.redis.sys.service.impl;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.redis.sys.model.GiftRequest;
import com.daimabaike.springboot.redis.sys.model.GiftResponse;
import com.daimabaike.springboot.redis.sys.service.IGiftService;

@Service("MhdGiftService")
public class MhdGiftServiceImpl implements IGiftService{

	@Override
	public GiftResponse send(GiftRequest req) {
		
		System.out.println("MhdGiftServiceImpl, appId=" + req.getAppId());
		
		// 参数不一样而已：
		
		return null;
	}

}
