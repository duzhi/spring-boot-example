package com.daimabaike.springboot.mybatis.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.dto.RoleUserDto;
import com.daimabaike.springboot.mybatis.sys.entity.RoleUser;
import com.daimabaike.springboot.mybatis.sys.service.RoleUserService;

@RestController
@RequestMapping(value = "sys")
public class RoleUserController extends BaseController {

	@Autowired
	private RoleUserService roleUserService;

	@RequestMapping(value = "role-user/{roleId}/{userId}")
	public RoleUser get(RoleUserDto roleUserDto) {
		RoleUser roleUser = roleUserService.get(roleUserDto);
		
		logger.info(roleUser.toString());
		return roleUser;
	}
}
