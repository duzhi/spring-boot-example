package com.daimabaike.biz.sys.entity;

import javax.validation.constraints.NotNull;

public class UserDTO {

	int id;
	@NotNull
//	@JsonView
	String name;
	//@DecimalMax("1111.22")
	String sex;

	int viewType;
	
	String[] filter;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public String[] getFilter() {
		return filter;
	}

	public void setFilter(String[] filter) {
		this.filter = filter;
	}
	
}
