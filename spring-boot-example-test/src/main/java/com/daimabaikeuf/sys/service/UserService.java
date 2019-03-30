package com.daimabaikeuf.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daimabaikeuf.sys.dao.UserDao;
import com.daimabaikeuf.sys.entity.User;
import com.daimabaikeuf.sys.model.CreateUserRequest;
import com.daimabaikeuf.sys.model.CreateUserResponse;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// 参数问题
	// 和返回值问题
	public CreateUserResponse insert(CreateUserRequest req) {
		CreateUserResponse resp = new CreateUserResponse();
		resp.setRequestId("req-123");

		User user = new User();
		user.setId(System.currentTimeMillis());
		user.setName(req.getName());
		user.setTel(req.getTel());
		userDao.insert(user);
		resp.setUserId(user.getId());
		return resp;

	}

}
