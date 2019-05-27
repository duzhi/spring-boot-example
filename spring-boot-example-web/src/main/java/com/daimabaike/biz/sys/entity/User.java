package com.daimabaike.biz.sys.entity;

import com.daimabaike.biz.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// 为了简单处理，dto vo 辅助字段，实体类自己字段相关的辅助信息，
// 如查询请求的范围、响应的字典标签：枚举，字典、一对一实体 ID 名称映射）放到 entity，需注明用途
// 一对一、一对多，多对多如果双方参与的字段很多，建议单独建 dto、vo
@JsonInclude(Include.NON_NULL)
public class User extends BaseEntity {

	private String name;
	
	private String deptNo;
	
	private String email;
	
	private String passWdMd5;
	
	private Integer passWdSalt;
	
	// 关联的角色
	private int roleId;
	private String roleName;
	
	
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
