package com.daimabaike.console.biz.scheduling;

import org.springframework.context.ApplicationEvent;

public class CycleEvent extends ApplicationEvent {

	// 周期，任务名称，周期起始参数，分区参数名称
	public CycleEvent(Object source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
