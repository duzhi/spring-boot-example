package com.daimabaike.springboot.mybatis.core.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class RequestUtils1 {

	public static String ip() {
		return (String)RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_REQUEST);
	}
	
}
