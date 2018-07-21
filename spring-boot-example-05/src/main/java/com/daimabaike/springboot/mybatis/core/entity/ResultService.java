package com.daimabaike.springboot.mybatis.core.entity;

public class ResultService<T> {

	public static final String SUCC = "0";
	public static final String SUCC_MESSAGE = "SUCC";
	public static final String FAIL = "1";
	public static final String FAIL_MESSAGE = "FAIL";

	private String code;
	private String message;

	private T result;
	
	public ResultService() {
		this.code = SUCC;
		this.message = SUCC_MESSAGE;
	}

	public ResultService(String message) {
		this(FAIL, message);
	}

	public ResultService(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
