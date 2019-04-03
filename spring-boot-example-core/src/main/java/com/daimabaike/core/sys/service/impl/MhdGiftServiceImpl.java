package com.daimabaike.core.sys.service.impl;

import org.springframework.stereotype.Service;

import com.daimabaike.core.sys.model.GiftRequest;
import com.daimabaike.core.sys.model.GiftResponse;
import com.daimabaike.core.sys.service.IGiftService;

@Service("MhdGiftService")
public class MhdGiftServiceImpl implements IGiftService{

	@Override
	public GiftResponse send(GiftRequest req) {
		
		System.out.println("MhdGiftServiceImpl, appId=" + req.getAppId());
		
		// 参数不一样而已：
		
		return null;
	}

}
