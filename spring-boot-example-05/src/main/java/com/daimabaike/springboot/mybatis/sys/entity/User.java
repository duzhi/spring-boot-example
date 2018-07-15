package com.daimabaike.springboot.mybatis.sys.entity;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class User extends BaseEntity<String> {

	private static final long serialVersionUID = 1L;

	private String name;

	private String tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("id=%s,name=%s,tel=%s", id, name, tel);
	}
	
}
