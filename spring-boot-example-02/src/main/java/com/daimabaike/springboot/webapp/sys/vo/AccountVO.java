package com.daimabaike.springboot.webapp.sys.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(Include.NON_NULL)

public class AccountVO {

	@JsonView(AccountVO.ChannelView.class)
	private String id;

	private String ip;

	private Date createTime;

	private Date updateTime;

	@JsonView(AccountVO.ChannelView.class)
	private String name;
	private String deptNo;

	private String email;

//	private String passWdMd5;
//
//	private Integer passWdSalt;

	public interface ChannelView {
	};

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
			// if ("id".equalsIgnoreCase(f)) {
			// id = null;
			// } else if ("name".equalsIgnoreCase(f)) {
			// name = null;
			// } else if ("email".equalsIgnoreCase(f)) {
			// email = null;
			// }
			System.out.println(System.nanoTime() - start);
		}

		// for(String f : fn) {
		// try {
		// long start = System.nanoTime();
		// ReflectionUtils.findField(this.getClass(), f).set(this, null);
		//
		// System.out.println(System.nanoTime()- start);
		// } catch (Exception e) {
		// // ignore
		// }
		// }
	}
}
