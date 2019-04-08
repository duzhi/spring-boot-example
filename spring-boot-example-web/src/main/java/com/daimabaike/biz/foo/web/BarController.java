package com.daimabaike.biz.foo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Bean("strTestBar")
	public String createA() {
		logger.info("strTestBar");
		return "strTestBarrggr";
	}
	
	@Autowired
	BarService barService;
	
	@Autowired
    @Qualifier("strTestBar")
	String sss;

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
			barService.order();
			r.setResult("12311");
		} catch (Exception e) {
			r.setResult("ex:" + e.getMessage());
		}
		return r;
	}
	
	@GetMapping("biz")
	public String biz() {
		
		 String biz =  barService.biz();
		logger.info("biz");
		return biz + sss;
		
	}
}
