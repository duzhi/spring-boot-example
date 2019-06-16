package com.daimabaike.biz.common;

public class BizException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private int code;
	
	public BizException() {
		super();
	}
	public BizException(int code,String message) {
		super(message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
