package com.daimabaike.springboot.mybatis.core.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = -7724447990363537876L;

	protected ID id;

	protected Date createDate;
	
	protected Date updateDate;

	protected int pageNum;
	protected int pageSize;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
