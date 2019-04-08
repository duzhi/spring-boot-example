package com.daimabaike.biz.foo.event;

import org.springframework.context.ApplicationEvent;

public class OrderSuccEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 203761816775889922L;

	public OrderSuccEvent(String orderId) {
		super(orderId);
	}
	
}
