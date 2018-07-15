package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.dao.UserDao;
import com.daimabaike.springboot.mybatis.sys.entity.User;

@Service
public class UserService extends BaseService<UserDao, User, String>{

}
