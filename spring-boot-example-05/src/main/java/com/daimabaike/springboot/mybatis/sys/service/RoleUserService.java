package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.mapper.RoleUserMapper;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUser;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUserID;

@Service
public class RoleUserService extends BaseService<RoleUserMapper,RoleUser,RoleUserID>{

}
