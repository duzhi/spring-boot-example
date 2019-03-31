package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.core.Result;
import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.dto.UserDto;
import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.mapper.UserMapper;

@Service
public class UserService extends BaseService<UserMapper, User, UserDto> {

	public int find(int time) {
		return dao.find(time);
	}
	

	/**
	 * @param user
	 * @return
	 */
	@Transactional
	public Result<User> doBiz(UserDto userDto) {
		logger.info("start doBiz");

		User u = this.queryForUpdateOne(userDto);

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
