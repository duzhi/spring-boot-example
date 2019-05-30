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
			// 2xx
			if (ru.getCode() != 0) { // 200 业务异常，注意有的三方 API 用 4xx，5xx 返回业务异常
				BizException bx = new BizException(ru.getMessage());
				bx.setCode(ru.getCode()); // 枚举或数据库字典映射。不匹配的则返回未知code，打印异常信息
				throw bx;
			}
			return ru.getData();
		} catch (RestClientResponseException e) { // 4xx, 5xx 异常

			logger.error("ResponseBody={}", e.getResponseBodyAsString());
			// 需要区分是正常异常（有的api 4xx 5xx返回业务异常），解析下；还是服务不正常异常（网关异常等）
			BizException bx = new BizException(e.getRawStatusCode() + ",body=" + e.getResponseBodyAsString());
			bx.setCode(400023);

			throw bx;
		} catch (RestClientException e1) { // 其他异常，如 UnknownHostException、ConnectException、SocketTimeoutException 等

			// @formatter:off

			// 连接超时
			// Caused by: java.net.SocketTimeoutException: connect timed out
			// at java.net.DualStackPlainSocketImpl.waitForConnect(Native Method) ~[na:1.8.0_171]
			// at java.net.DualStackPlainSocketImpl.socketConnect(Unknown Source) ~[na:1.8.0_171]
			// at java.net.AbstractPlainSocketImpl.doConnect(Unknown Source) ~[na:1.8.0_171]
			
			// 读超时
			// Caused by: java.net.SocketTimeoutException: Read timed out
			// at java.net.SocketInputStream.socketRead0(Native Method) ~[na:1.8.0_171]
			// at java.net.SocketInputStream.socketRead(Unknown Source) ~[na:1.8.0_171]
			// at java.net.SocketInputStream.read(Unknown Source) ~[na:1.8.0_171]

			// @formatter:on

			logger.error("login RestClientException:", e1);
			BizException bx = new BizException(e1.getMessage());
			bx.setCode(400021);
			throw bx;
		}

	}

}