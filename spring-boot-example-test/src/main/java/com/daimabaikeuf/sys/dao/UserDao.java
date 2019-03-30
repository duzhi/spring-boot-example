package com.daimabaikeuf.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.daimabaikeuf.sys.entity.User;

@Mapper
public interface UserDao {
	
	public Long insert(User user);
	
//	CRUD
//	CUD 发生的指定字段，特殊情况 UD 的条件也可以是日期区间的；
//	单表业务
	
}
