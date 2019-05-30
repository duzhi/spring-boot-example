package com.daimabaike.springboot.mybatis.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUser;

@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {

	// @Override
	@Select("select * from sys_role_user where role_id=#{roleId} and user_id=#{userId}")
	RoleUser get(RoleUser roleUserDto);

}
