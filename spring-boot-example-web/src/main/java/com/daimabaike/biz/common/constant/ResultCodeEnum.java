package com.daimabaike.biz.common.constant;

public enum ResultCodeEnum {

	SUCCESS(0,"OK"),
	SYS11(40001,"ABCD");
	
	private int code;
	private String message;
	
	ResultCodeEnum(int code,String message){
		this.code = code;
		this.message = message;
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
	
}
