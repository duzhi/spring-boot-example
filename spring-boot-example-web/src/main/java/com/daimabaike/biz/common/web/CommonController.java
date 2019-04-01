package com.daimabaike.biz.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.ErrorResult;
import com.daimabaike.biz.common.ErrorResult.ErrorInfo;
import com.daimabaike.biz.common.Result;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
@RestController
public class CommonController extends BaseController {

	@ExceptionHandler(BizException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Void> bizException(BizException t) {
		
		Result<Void> r = new Result<>();

		return r;
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Void> bindException(BindException t) {
		
		Result<Void> r = new Result<>();

		return r;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorResult httpMessageNotReadableException(HttpMessageNotReadableException t) {
		
		log.info("getLocalizedMessage-="+t.getLocalizedMessage());
		InvalidFormatException ie = (InvalidFormatException)t.getCause();
		
		
		log.info(ie.getMessage());

		
		ie.getPath().get(0).getFieldName();
		return new ErrorResult("40000","OriginalMessage=" + ie.getOriginalMessage() +";\r\nMessage=" + ie.getMessage() +";\r\nPathReference="+ie.getPathReference()+""+ie.getPath());

	}
	
	
	@ExceptionHandler(HttpServerErrorException.class)
	public Result<Void> ex22(HttpServerErrorException t) {
		log.error("sys.error", t);

//		r.setCode(50000);
		return JSONObject.parseObject(t.getResponseBodyAsString(), new TypeReference<Result<Void>>(){});
		
//		Result<Void> r = new Result<>();
//		r.setCode(50000);
//		r.setMessage("Client Error or Server Error");
//
//		return r;
	}
	@ExceptionHandler(Throwable.class)
	public ErrorResult ex(Throwable t) {
		log.error("sys.error", t);


		return new ErrorResult("50000","Client Error or Server Error");
	}
	
}
