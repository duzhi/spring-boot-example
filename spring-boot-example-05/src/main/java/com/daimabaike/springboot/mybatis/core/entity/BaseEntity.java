package com.daimabaike.springboot.mybatis.core.entity;

import java.util.Date;

public class BaseEntity<ID> {

	protected ID id;

	protected Date createDate;
	
	protected Date updateDate;

	protected int pageNum;
	protected int pageSize;

	protected String verifymessage;
	
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
	
	public boolean validate(){
		return true;
	}

	public String getVerifymessage() {
		return verifymessage;
	}

	public void setVerifymessage(String verifymessage) {
		this.verifymessage = verifymessage;
	}
	
}
