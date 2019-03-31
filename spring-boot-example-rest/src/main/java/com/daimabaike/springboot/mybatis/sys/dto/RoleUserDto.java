package com.daimabaike.springboot.mybatis.sys.dto;

import com.daimabaike.springboot.mybatis.core.dto.BaseDto;

public class RoleUserDto extends BaseDto{

	private String roleId;
	private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
