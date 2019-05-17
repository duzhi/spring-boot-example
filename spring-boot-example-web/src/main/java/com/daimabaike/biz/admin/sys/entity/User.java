package com.daimabaike.biz.admin.sys.entity;

import com.daimabaike.biz.common.entity.BaseEntity;

public class User extends BaseEntity {

	private String name;
	
	private String deptNo;
	
	private String email;
	
	private String passWdMd5;
	
	private Integer passWdSalt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWdMd5() {
		return passWdMd5;
	}

	public void setPassWdMd5(String passWdMd5) {
		this.passWdMd5 = passWdMd5;
	}

	public Integer getPassWdSalt() {
		return passWdSalt;
	}

	public void setPassWdSalt(Integer passWdSalt) {
		this.passWdSalt = passWdSalt;
	}
	
}
