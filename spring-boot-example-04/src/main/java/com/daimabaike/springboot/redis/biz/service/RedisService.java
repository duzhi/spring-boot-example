package com.daimabaike.springboot.redis.biz.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void hSet(String key, String item, Object value) {
		redisTemplate.opsForHash().put(key, item, value);
	}

	@SuppressWarnings("unchecked")
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
			boolean d = redisTemplate.opsForValue().setIfAbsent(key1, "uid");
			if (d) {
				return token;
			}
			
			if (redisTemplate.expire(key1, 10L, TimeUnit.MINUTES)) {
				String a = (String)redisTemplate.opsForValue().get(key1);
				return a;
			}
		}
		
	}
}
