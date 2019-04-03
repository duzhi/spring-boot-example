package com.daimabaike.core.sys.service.impl;

import org.springframework.stereotype.Service;

import com.daimabaike.core.sys.model.GiftRequest;
import com.daimabaike.core.sys.model.GiftResponse;
import com.daimabaike.core.sys.service.IGiftService;

@Service("ZmgGiftService")
public class ZmgGiftServiceImpl implements IGiftService{

	@Override
	public GiftResponse send(GiftRequest req) {
		System.out.println("ZmgGiftServiceImpl, appId=" + req.getAppId());
		return null;
	}

}
