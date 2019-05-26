package com.daimabaike.biz.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result<T> {

	private int code;

	private String message;

	private T data;
	
	public static <T> Result<T> ok(T data){
		Result<T> r = new Result<>();
		r.setCode(200);
		r.setMessage("success");
		r.setData(data);
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
