package com.daimabaike.spring.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@EnableCaching
@Configuration
public class Config2 {

	@Value("${spring.redis.host}")
	private String hostName;

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.cache.redis.time-to-live}")
	private String timeToLive;
	
	@Primary
	@Bean("cf1")
//	@Lazy
	public RedisConnectionFactory connectionFactory1111() {
		LettuceConnectionFactory f = new LettuceConnectionFactory();

		f.getStandaloneConfiguration().setHostName(hostName);
		f.getStandaloneConfiguration().setDatabase(database);
		f.getStandaloneConfiguration().setPort(port);
		f.getStandaloneConfiguration().setPassword(RedisPassword.of(password));

		
//		f.getClusterConfiguration().
		return f;
	}
    
	@Bean("cf2")
//	@Lazy
	public RedisConnectionFactory connectionFactory() {
		LettuceConnectionFactory f = new LettuceConnectionFactory();

		f.getStandaloneConfiguration().setHostName(hostName);
		f.getStandaloneConfiguration().setDatabase(2);
		f.getStandaloneConfiguration().setPort(port);
		f.getStandaloneConfiguration().setPassword(RedisPassword.of(password));

		return f;
	}
	@Primary
	@Bean("rcm1")   
	public RedisCacheManager cacheManager1(@Autowired @Qualifier("cf1") RedisConnectionFactory connectionFactory) {
		RedisCacheManager cm = RedisCacheManager.create(connectionFactory);
//		
//	    cm.setDefaultExpiration(60);
//	    Map<String,Long> expiresMap=new HashMap<>();
//	    expiresMap.put("Product",5L);
//	    cacheManager.setExpires(expiresMap);


	    return cm;
	}
	@Bean("rcm2")   
	public RedisCacheManager cacheManager221(@Autowired @Qualifier("cf2") RedisConnectionFactory connectionFactory) {
		RedisCacheManager cm = RedisCacheManager.create(connectionFactory);
		
	    return cm;
	}
	
	@Bean("redisTemplate")
	public RedisTemplate<?, ?> xx(@Autowired @Qualifier("cf1") RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
	
}
