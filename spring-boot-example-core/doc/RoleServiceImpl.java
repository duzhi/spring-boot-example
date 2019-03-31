package com.daimabaike.spring.session.sys.service;

import java.util.Random;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "roles", cacheManager = "rcm2")
@Service
public class RoleServiceImpl implements RoleService {
//	@Resource
//	private UserDao userDao;
//	, sync = true
	@Cacheable(cacheNames = "test1", key = "#id")
	@Override
	public String test(int id) {
		return new Random().nextInt(100) + "";
	}

}
