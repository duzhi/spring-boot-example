package com.daimabaike.springboot.mybatis.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result<T> {

	private int code;
	private String message;
	private T data;

	private Result() {
	}

	public static <T> Result<T> ok() {
		Result<T> r = new Result<>();
		r.setCode(0);
		r.setMessage("success");
		return r;
	}

	public static <T> Result<T> ok(T t) {
		Result<T> r = ok();
		r.setData(t);
		return r;
	}

	public static <T> Result<T> fail(String message) {
		Result<T> r = new Result<>();
		r.setCode(1);
		r.setMessage(message);
		return r;
	}

	public static <T> Result<T> fail(String message, T t) {
		Result<T> r = fail(message);
		r.setData(t);
		return r;
	}

	public static <T> Result<T> fail(int code, String message) {
		Result<T> r = new Result<>();
		r.setCode(code);
		r.setMessage(message);
		return r;
	}

	public static <T> Result<T> fail(int code, String message, T t) {
		Result<T> r = fail(code, message);
		r.setData(t);
		return r;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
