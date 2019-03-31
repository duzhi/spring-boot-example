package com.daimabaike.springboot.redis.sys.service;

import com.daimabaike.springboot.redis.sys.model.GiftRequest;
import com.daimabaike.springboot.redis.sys.model.GiftResponse;

public interface IGiftService {

	GiftResponse send(GiftRequest req);
	
}
