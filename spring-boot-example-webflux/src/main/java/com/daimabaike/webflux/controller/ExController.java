package com.daimabaike.webflux.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ExController {
    @ExceptionHandler(Exception.class)
	public Map<String, Object> bizException(Exception ex) {
		Map<String, Object> result = new HashMap<>();

		result.put("error_code", "40000");
		result.put("error_message", "Not Exists" + ex.getClass());

		return result;
	}
}
