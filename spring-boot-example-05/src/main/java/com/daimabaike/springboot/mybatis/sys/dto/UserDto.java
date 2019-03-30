package com.daimabaike.springboot.mybatis.sys.dto;

import com.daimabaike.springboot.mybatis.core.dto.BaseDto;

public class UserDto extends BaseDto{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
