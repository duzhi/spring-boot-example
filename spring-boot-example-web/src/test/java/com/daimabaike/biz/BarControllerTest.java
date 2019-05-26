package com.daimabaike.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.foo.entity.DailyData;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BarControllerTest {

	@LocalServerPort
	public int definedPort;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * 测试服务端接口
	 */
	@Test
	public void xsx() {
		String url = String.format("http://localhost:%s/bar/zd", definedPort);

		ParameterizedTypeReference<Result<DailyData>> responseType = new ParameterizedTypeReference<Result<DailyData>>() {
		};

		ResponseEntity<Result<DailyData>> rsp = restTemplate.exchange(url, HttpMethod.GET, null/* httpEntity */,
				responseType);

		System.out.println(rsp.getStatusCodeValue());

		System.out.println(rsp.getBody().getData().getClass());

	}
	
	@Test
	public void test1() {
		HttpHeaders s = new HttpHeaders();
		System.out.println(restTemplate.exchange("https://ad.toutiao.com/open_api/oauth2/access_token/", HttpMethod.GET, new HttpEntity<>(s), String.class));
	}
}
