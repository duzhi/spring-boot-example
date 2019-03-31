package com.daimabaike.springboot.redis.sys.service.impl;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.redis.sys.model.GiftRequest;
import com.daimabaike.springboot.redis.sys.model.GiftResponse;
import com.daimabaike.springboot.redis.sys.service.IGiftService;

@Service("GiftService")
public class GiftServiceImpl implements IGiftService{

//	IGiftService mhdGiftService;
//	
//	IGiftService zmgGiftService;
	
	@Override
	public GiftResponse send(GiftRequest req) {
		return null;
	}

	
}
