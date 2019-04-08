package com.daimabaike.biz.foo.event;

import org.springframework.context.ApplicationEvent;

public class OtherEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OtherEvent(String orderId) {
		super(orderId);
	}
	
}
