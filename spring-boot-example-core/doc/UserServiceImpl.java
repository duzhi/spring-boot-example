package com.daimabaike.spring.session.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

//import com.daimabaike.spring.session.sys.dao.UserDao;
import com.daimabaike.spring.session.sys.entity.User;

@CacheConfig(cacheNames= {"users:c1"},cacheManager="rcm1")
@Service
public class UserServiceImpl implements UserService {
//	@Resource
//	private UserDao userDao;
//, sync = true cacheNames="test#1#id",
//	@Cacheable(key="#id")
	@Override
	public Map<String,Object> test(int id) {
		
		System.out.println("test()," + new Date());
		
//		String res =  userDao.test();
		
//		System.out.println("res="+res);
		
		Map<String,Object> m = new HashMap<String,Object>();
		
//		m.put("aa", res);
		
		return m;
	}
	
	
	
	@Override
	public User get(int id) {
		
		return new User();
	}
}
