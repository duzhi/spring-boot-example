package com.daimabaike.springboot.mybatis.sys.model;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class StatUser extends BaseEntity {

	// 登陆次数
	private Long loginTimes;

	public Long getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Long loginTimes) {
		this.loginTimes = loginTimes;
	}

}
