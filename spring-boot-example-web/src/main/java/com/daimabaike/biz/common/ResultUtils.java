package com.daimabaike.biz.common;

public class ResultUtils {

	public static <T> Result<T> ok(T data) {
		Result<T> r = new Result<>();
		r.setCode(0);
		r.setMessage("ok");
		r.setData(data);
		return r;
	}
	
}
