package com.daimabaike.springboot.mybatis.sys.entity;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class RoleUser extends BaseEntity {

	private String roleId;
	private String userId;

	private String remark;

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
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
