package com.daimabaike.biz.sys.model;

import java.util.Date;

import com.daimabaike.biz.common.model.BaseResponse;
import com.daimabaike.biz.sys.cons.XueliEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AccountResponse extends BaseResponse {

	private String id;

	private String ip;

	private Date createTime;

	private Date updateTime;

	private String name;
	
	private String deptNo;

	private String email;

	private int xx;
	
	private String xxLab;
	
	public int getXx() {
		return xx;
	}

	public void setXx(int xx) {
		this.xx = xx;
		
		setXxLab(XueliEnum.valueOf(xx).getName());
	}

	public String getXxLab() {
		return xxLab;
	}

	public void setXxLab(String xxLab) {
		this.xxLab = xxLab;
	}

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public void filter(String[] fn) {
		if (fn == null) {
			return;
		}
		for (String f : fn) {
			long start = System.nanoTime();

			switch (f) {
			case "id":
				id = null;
				break;
			case "name":
				name = null;
				break;
			case "email":
				email = null;
				break;
			default:
				break;
			}
			System.out.println(System.nanoTime() - start);
		}
	}
}
