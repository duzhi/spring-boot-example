package com.daimabaike.biz.foo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.foo.dto.BarDTO;
import com.daimabaike.biz.foo.service.BarService;

@RequestMapping("bar")
@RestController
public class BarController extends BaseController {

	@Autowired
	BarService barService;

	@RequestMapping(value = "query")
	public String test(@RequestBody BarDTO dto) {

		if (dto.getType() == 2) {
			throw new RuntimeException();
		}

		return dto.toString();
	}

	@GetMapping("name")
	public Result<String> name() {

		// service1

		// service2
		Result<String> r = new Result<>();
		try {

			r.setResult(barService.order());
		} catch (Exception e) {
			r.setResult("ex:" + e.getMessage());
		}
		return r;
	}
}
