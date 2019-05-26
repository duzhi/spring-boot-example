package com.daimabaike.biz.common;

public class BizException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private int status;
	
	private int code;
	
	public BizException() {
		super();
	}
	public BizException(String message) {
		super(message);
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
