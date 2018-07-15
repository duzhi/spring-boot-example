package com.daimabaike.springboot.mybatis.sys.entity;

import java.io.Serializable;

public class RoleUserID implements Serializable {

	private static final long serialVersionUID = 5814887617432272335L;

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
