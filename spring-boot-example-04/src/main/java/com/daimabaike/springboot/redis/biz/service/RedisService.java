package com.daimabaike.springboot.redis.biz.service;

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
}
