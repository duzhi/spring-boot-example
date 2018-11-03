package com.daimabaike.springboot.webapp.common.web;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.webapp.common.Result;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
@RestController
public class CommonController extends BaseController {

	
	
	@ExceptionHandler(BindException.class)
	public Result<Void> bindException(BindException t) {
		log.info(t.getAllErrors().get(0).getDefaultMessage());

		
		
		Result<Void> r = new Result<>();
		r.setCode(40000);
		r.setMessage(t.getAllErrors().get(0).getDefaultMessage());

		return r;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result<Void> httpMessageNotReadableException(HttpMessageNotReadableException t) {
		
		log.info("getLocalizedMessage-="+t.getLocalizedMessage());
		InvalidFormatException ie = (InvalidFormatException)t.getCause();
		
		
		log.info(ie.getMessage());

		
		ie.getPath().get(0).getFieldName();
		Result<Void> r = new Result<>();
		r.setCode(40000);
		r.setMessage("OriginalMessage=" + ie.getOriginalMessage() +";\r\nMessage=" + ie.getMessage() +";\r\nPathReference="+ie.getPathReference()+""+ie.getPath());

		return r;
	}
	@ExceptionHandler(Throwable.class)
	public Result<Void> ex(Throwable t) {
		log.error("sys.error", t);

		Result<Void> r = new Result<>();
		r.setCode(50000);
		r.setMessage("Client Error or Server Error");

		return r;
	}
	
}
