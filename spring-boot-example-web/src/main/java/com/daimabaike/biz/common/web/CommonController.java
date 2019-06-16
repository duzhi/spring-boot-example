package com.daimabaike.biz.common.web;

import com.daimabaike.biz.common.ResultCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.Result;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class CommonController extends BaseController {

	@ExceptionHandler(BizException.class)
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Void> bizException(BizException t) {

		Result<Void> r = new Result<>();
		r.setCode(t.getCode());
		r.setMessage(t.getMessage());
		return r;
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Void> bindException(BindException t) {

		Result<Void> r = new Result<>();

		return r;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result<Void> httpMessageNotReadableException(HttpMessageNotReadableException t) {

		logger.info("getLocalizedMessage-=" + t.getLocalizedMessage());
		InvalidFormatException ie = (InvalidFormatException) t.getCause();

		logger.info(ie.getMessage());

		ie.getPath().get(0).getFieldName();
		return Result.fail(ResultCodeEnum.SYS11);

	}

	@ExceptionHandler(HttpServerErrorException.class)
	public Result<Void> ex22(HttpServerErrorException t) {
		logger.error("sys.error", t);

		// r.setCode(50000);
		return JSONObject.parseObject(t.getResponseBodyAsString(), new TypeReference<Result<Void>>() {
		});

		// Result<Void> r = new Result<>();
		// r.setCode(50000);
		// r.setMessage("Client Error or Server Error");
		//
		// return r;
	}

	@ExceptionHandler(Throwable.class)
	public Result<Void> ex(Throwable t) {
		logger.error("sys.error", t);
		return Result.fail(ResultCodeEnum.SYS11);
	}

}
