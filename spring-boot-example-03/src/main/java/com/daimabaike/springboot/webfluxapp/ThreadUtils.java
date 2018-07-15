package com.daimabaike.springboot.webfluxapp;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadUtils {

	private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

	public static void print() {
		ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
		for (long tid : tmxb.getAllThreadIds()) {
			ThreadInfo info = tmxb.getThreadInfo(tid);

			logger.info("ThreadId: {}", info.getThreadId());
			logger.info("ThreadName: {}", info.getThreadName());
			logger.info("ThreadState: {}", info.getThreadState());
		}
	}
}
