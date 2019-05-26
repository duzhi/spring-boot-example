package com.daimabaike.biz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 同级的也会扫描到
 * @author duzhi
 *
 */
@RestController
public class SameLevelController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("SameLevel")
	public Date biz() {
		logger.info("biz");

		return new Date();
	}
}
