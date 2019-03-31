package com.daimabaike.springboot.mybatis.sys.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class User extends BaseEntity {

	@NotNull(message="名称不能为空")
	private String name;
	
	@Length(min=1, max=13, message="电话长度必须介于 1 和 13 之间")
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
