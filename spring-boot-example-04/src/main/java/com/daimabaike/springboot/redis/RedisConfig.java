package com.daimabaike.springboot.redis;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		// Json 序列化
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		// key HashKey 都使用String序列化
		template.setKeySerializer(template.getStringSerializer());
		template.setHashKeySerializer(template.getStringSerializer());

		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
