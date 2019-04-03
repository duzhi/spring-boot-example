package com.daimabaike.core.sys.service;

import com.daimabaike.core.sys.model.GiftRequest;
import com.daimabaike.core.sys.model.GiftResponse;

public interface IGiftService {

	GiftResponse send(GiftRequest req);
	
}
