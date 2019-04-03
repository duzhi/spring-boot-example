package com.daimabaike.core.sys.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.daimabaike.core.sys.entity.User;

@Service
public class RedisService<T,HK,HV> {

	@Autowired
	private RedisTemplate<String, ?> redisTemplate;
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> RedisTemplate<String, T> getT() {
		return (RedisTemplate<String, T>) redisTemplate;
	}

	
	
	
	public void hSet(String key, String item, User value) {
		
		final RedisTemplate<String,String> rt = getT();
		
		HashOperations<String,String,User> ops = rt.opsForHash();
		ops.put(key, item, value);
		
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T hGet(String key, String item, Class<T> clzz) {
		
		return (T) (redisTemplate.opsForHash().get(key, item));
	}

	/**
	 * 唯一key，uid
	 * @param key
	 * @param item
	 * @param value
	 * @return
	 */
	public String ddd(String key, String item, Object value) {

		for (;;) {
			String token = "token_create";
			String key1 = "biz:" + token;
//			ValueOperations<String, String> a= redisTemplate.opsForValue();
//			boolean d = redisTemplate.opsForValue().setIfAbsent(key1, "uid");
//			if (d) {
//				return token;
//			}
			
			if (redisTemplate.expire(key1, 10L, TimeUnit.MINUTES)) {
				String a = (String)redisTemplate.opsForValue().get(key1);
				return a;
			}
		}
		
	}
	
	
}
