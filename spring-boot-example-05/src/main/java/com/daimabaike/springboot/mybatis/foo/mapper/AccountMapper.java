package com.daimabaike.springboot.mybatis.foo.mapper;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.foo.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account,BigInteger>{

//	@Override
	@Select("select * from account where id=#{id}")
	Account get(@Param("id") BigInteger id);
	
}
