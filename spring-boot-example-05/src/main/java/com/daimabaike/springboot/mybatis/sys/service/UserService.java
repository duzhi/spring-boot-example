package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.core.entity.Result;
import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.mapper.UserMapper;
import com.daimabaike.springboot.mybatis.sys.entity.User;

@Service
public class UserService extends BaseService<UserMapper, User, String> {

	public int find(int time) {
		return dao.find(time);
	}

	/**
	 * @param user
	 * @return
	 */
	@Transactional
	public Result<User> doBiz(User user) {
		logger.info("start doBiz");

		User u = this.queryForUpdateOne(user);

		logger.info(u);

		logger.info("debug dot");

		if (u == null) {
			return Result.fail("aaa");
		}
		if ("123".equals(u.getName())) {
			return Result.fail("bbb");
		}

		return Result.ok(u);

	}

}
