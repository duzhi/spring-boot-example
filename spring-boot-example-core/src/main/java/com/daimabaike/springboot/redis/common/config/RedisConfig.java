package com.daimabaike.springboot.redis.common.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration

public class RedisConfig {

//	@Bean(name = "redisTemplate")
//	public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory redisConnectionFactory)
//			throws UnknownHostException {
//		RedisTemplate<String, T> template = new RedisTemplate<>();
//		// Json 序列化
//		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//		// key HashKey 都使用String序列化
//		template.setKeySerializer(template.getStringSerializer());
//		template.setHashKeySerializer(template.getStringSerializer());
//
//		template.setConnectionFactory(redisConnectionFactory);
//		return template;
//	}

//	@Bean
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofMillis(10)); //
//		
		System.out.println("RedisConfig.cacheManager");
//		
//		Set<String> aa = new HashSet<>();
//		aa.add("sys");
//		return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).initialCacheNames(aa)
//				.cacheDefaults(redisCacheConfiguration).build();
		
		
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // 配置序列化（解决乱码的问题）
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMillis(10))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();

        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
        return cacheManager;

	}
}
