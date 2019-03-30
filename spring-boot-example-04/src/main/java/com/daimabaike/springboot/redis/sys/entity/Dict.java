package com.daimabaike.springboot.redis.sys.entity;

import java.io.Serializable;

public class Dict implements Serializable{

	private static final long serialVersionUID = -9164142129215919964L;

	private String code;
	
	private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
