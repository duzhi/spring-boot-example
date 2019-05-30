package com.daimabaike.springboot.mybatis.sys.service;

import java.util.List;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.mapper.StatUserMapper;
import com.daimabaike.springboot.mybatis.sys.model.StatUser;
import com.daimabaike.springboot.mybatis.sys.model.StatUserResp;

public class StatUserService extends BaseService<StatUserMapper, StatUser>{

	public List<StatUserResp> statLoginTimes(StatUser statUser){
		return null;
	}
	
}
