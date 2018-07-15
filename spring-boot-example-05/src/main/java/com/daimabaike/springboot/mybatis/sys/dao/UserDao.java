package com.daimabaike.springboot.mybatis.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.dao.BaseDao;
import com.daimabaike.springboot.mybatis.sys.entity.User;

@Mapper
public interface UserDao extends BaseDao<User,String> {

	@Override
	@Select("select * from user where id=#{id}")
	User get(@Param("id") String id);

}
