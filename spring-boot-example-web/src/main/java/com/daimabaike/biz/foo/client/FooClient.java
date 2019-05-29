package com.daimabaike.biz.foo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.sys.entity.User;

@Service
public class FooClient {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	public User login() {

		try {
			Result<User> ru = restTemplate.exchange("http://localhost:8000/sys/user/11", HttpMethod.GET, null,
					new ParameterizedTypeReference<Result<User>>() {
					}).getBody();
			if (ru.getCode() != 0) { // 200 业务异常，有的三方 API 可能用 4xx，5xx 返回业务异常
				BizException bx = new BizException(ru.getMessage());
				bx.setCode(ru.getCode()); // 枚举或数据库字典映射。不匹配的则返回未知code，打印异常信息
				throw bx;
			}
			return ru.getData();
		} catch (RestClientResponseException e) { // 4xx, 5xx 异常

			// 需要区分是正常异常（有的api 4xx 5xx返回业务异常），解析下；还是服务不正常异常（网关异常等）
			BizException bx = new BizException(e.getRawStatusCode() + e.getResponseBodyAsString());
			bx.setCode(400023);

			throw bx;
		} catch (RestClientException e1) { // 其他异常

			logger.error("login RestClientException:", e1);
			BizException bx = new BizException(e1.getMessage());
			bx.setCode(400021);
			throw bx;
		}
		// 2xx

	}

}