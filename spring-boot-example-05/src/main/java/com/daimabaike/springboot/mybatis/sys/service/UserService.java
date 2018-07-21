package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.core.entity.ResultService;
import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.dao.UserDao;
import com.daimabaike.springboot.mybatis.sys.entity.User;

@Service
public class UserService extends BaseService<UserDao, User, String> {

	public int find(int time) {
		return dao.find(time);
	}

	/**
	 * @param user
	 * @return
	 */
	@Transactional
	public ResultService<User> doBiz(User user) {
		ResultService<User> r = new ResultService<>();
		logger.info("start doBiz");

		User u = this.queryForUpdateOne(user);

		logger.info(u);

		logger.info("debug dot");

		if ("123".equals(u.getName())) {
			r.setCode("abc");
			r.setMessage("dsdsd");
			return r;
		}
		r.setResult(u);
		return r;
		
	}

}
