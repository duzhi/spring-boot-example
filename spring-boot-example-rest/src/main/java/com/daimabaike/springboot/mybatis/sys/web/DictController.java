package com.daimabaike.springboot.mybatis.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.mybatis.core.web.BaseController;
import com.daimabaike.springboot.mybatis.sys.dto.DictDto;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;
import com.daimabaike.springboot.mybatis.sys.service.DictService;

@RestController
@RequestMapping(value = "sys")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;

	@RequestMapping(value = "dict/{id}")
	public Dict get(DictDto dictDto) {
		Dict dict = dictService.get(dictDto);

		logger.info("dict = {}", dict == null ? "" : dict.toString());

		return dict;
	}

}
