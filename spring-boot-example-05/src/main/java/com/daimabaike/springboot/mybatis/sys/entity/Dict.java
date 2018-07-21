package com.daimabaike.springboot.mybatis.sys.entity;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class Dict extends BaseEntity<Integer> {
	
	private String type;
	private String value;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
