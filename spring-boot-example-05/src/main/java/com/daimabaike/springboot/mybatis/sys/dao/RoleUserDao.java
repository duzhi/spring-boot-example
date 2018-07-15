package com.daimabaike.springboot.mybatis.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.dao.BaseDao;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUser;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUserID;
@Mapper
public interface RoleUserDao extends BaseDao<RoleUser,RoleUserID>{

	@Override
	@Select("select * from sys_role_user where role_id=#{roleId} and user_id=#{userId}")
	RoleUser get( RoleUserID id);
	
}
