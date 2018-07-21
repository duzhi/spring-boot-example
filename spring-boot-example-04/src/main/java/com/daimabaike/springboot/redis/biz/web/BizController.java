package com.daimabaike.springboot.redis.biz.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.redis.biz.entity.User;
import com.daimabaike.springboot.redis.biz.service.RedisService;

@RequestMapping("biz")
@RestController
public class BizController {

	protected Logger logger = LoggerFactory.getLogger(BizController.class);

	@Autowired
	private RedisService redisService;

	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	@RequestMapping("foo")
	public String foo() {
		User user = new User();
		user.setId("abc");
		user.setEmail("aaaa@jdw.com");
		user.setName("zsam");
		user.setRemark("okaa");
		redisService.hSet("a", user.getId(), user);

		logger.info("user={}", user);

		User obj = redisService.hGet("a", user.getId(), User.class);

		return String.format("obj.name=%s,obj.class=%s", obj.getName(), obj.getClass());
	}

}
