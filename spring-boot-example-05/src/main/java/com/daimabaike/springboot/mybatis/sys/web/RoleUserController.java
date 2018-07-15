package com.daimabaike.springboot.mybatis.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUser;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUserID;
import com.daimabaike.springboot.mybatis.sys.service.RoleUserService;

@RestController
public class RoleUserController extends BaseController {

	@Autowired
	private RoleUserService roleUserService;

	@RequestMapping(value = "/roleUser")
	public RoleUser get(RoleUserID id) {
		RoleUser roleUser = roleUserService.get(id);

		logger.info(roleUser.toString());
		return roleUser;
	}
}
