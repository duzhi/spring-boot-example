package com.daimabaike.springboot.mybatis.sys.entity;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class RoleUser extends BaseEntity<RoleUserID> {

	private static final long serialVersionUID = -308406718883396769L;

	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
