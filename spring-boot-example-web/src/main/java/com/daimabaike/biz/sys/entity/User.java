package com.daimabaike.biz.sys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.daimabaike.biz.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

// 为了简单处理，DTO、VO 的辅助字段是实体类自己字段相关的辅助信息，如查询请求的日期范围、响应的字典标签：
// 枚举名称，字典名称、一对一关联实体 ID 名称映射，可以放到 entity，需注明来源（请求还是响应）和用途。
// 如果结果中有很多两个及以上表参与的字段（一对一、一对多），建议单独建 DTO、VO（或request、response）；
// 多对多建议固定一方 id，页面展示一方少量明细，另一方展示列表的方式来呈现信息（如用户角色信息关联表，可以在用户角色分配页展示角色列表）
@JsonInclude(value=Include.NON_NULL)
public class User extends BaseEntity {

	@NotNull(message="名称不能为空")
	@JsonProperty("name")
	@JsonAlias("n")
	private String name;
	
	private String deptNo;
	
	private String email;
	
	private String passWdMd5;
	
	private Integer passWdSalt;
	
	// 关联的角色列表
	@JsonInclude(value=Include.NON_EMPTY)
	private List<Role> roles;
	
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
