package com.daimabaike.biz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 同级的也会扫描到
 * @author duzhi
 *
 */
@Controller
public class SameLevelController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("SameLevel")
	@ResponseBody
	public Date biz() {
		logger.info("biz");

		return new Date();
	}
	@RequestMapping(value = "test")
	public String test() {
		return "test";
	}
}
