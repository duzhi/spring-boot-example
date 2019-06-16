package com.daimabaike.biz.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.daimabaike.biz.common.Result;

@ControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {

	protected Logger logger = LoggerFactory.getLogger(ResultResponseHandler.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

		if (RequestContextHolder.getRequestAttributes().getAttribute(ResultRewriteInterceptor.RESULT_REWRITE,
				RequestAttributes.SCOPE_REQUEST) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		if (body == null) {
			logger.info("the body is null");
		} else {
			logger.info("the body name:{}", body.getClass().getName());
		}

		// Result 不再转，比如发生异常时
		if (body instanceof Result) {// || body instanceof
			return body;
		}
		// String 由于匹配的 StringHttpMessageConverter 转化器，会认为返回值是 String，
		// 如果是其他对象，会发生类型转换错误；所以先转好
		else if(body instanceof String){
			return "{\"code\":200,\"message\":\"success\",\"data\":\"" + body +"\"}";
		}

		return Result.ok(body);
	}
}
