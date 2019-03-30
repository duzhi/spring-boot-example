package com.daimabaike.springboot.mybatis.foo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.foo.dto.AccountDto;
import com.daimabaike.springboot.mybatis.foo.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account,AccountDto>{

	@Select("select * from account where id=#{id}")
	Account get(AccountDto dto);
	
}
