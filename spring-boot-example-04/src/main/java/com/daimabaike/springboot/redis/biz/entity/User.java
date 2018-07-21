package com.daimabaike.springboot.redis.biz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private String id;
	private String name;
	private String email;
	private String remark;

	@JsonIgnore
	private String status = "0";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "id=" + id + ",name=" + name + ",email=" + email + ",remark=" + remark + ",status=" + status;
	}
}
