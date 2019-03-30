package com.daimabaike.springboot.redis.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.redis.sys.entity.Dict;
import com.daimabaike.springboot.redis.sys.service.SysCacheService;

@RestController
public class DictController {
	
	@Autowired
	private SysCacheService sysCacheService;
	
	@RequestMapping("dict")
	public List<Dict> dict() {
		return sysCacheService.query("sd");
	}
	@RequestMapping("dict11")
	public Dict dic1t1() {
		return sysCacheService.query11("sd");
	}
	
}
