package com.daimabaike.core.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.core.sys.model.GiftRequest;
import com.daimabaike.core.sys.model.OppoGiftRequest;
import com.daimabaike.core.sys.service.IGiftService;

@RestController
public class GiftController {

	@Autowired
	@Qualifier("GiftService")
	IGiftService giftService;
	
	@RequestMapping("gift")
	public String aa( OppoGiftRequest req) {
		
		GiftRequest giftRequest = new GiftRequest();
		giftRequest.setAppId("2000");
		
		giftService.send(giftRequest);
		
		return "succ";
		
	}
	
	
}
