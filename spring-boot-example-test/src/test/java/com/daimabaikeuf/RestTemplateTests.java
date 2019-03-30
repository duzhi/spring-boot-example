package com.daimabaikeuf;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestTemplateTests {

    @LocalServerPort
    public int definedPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest3() {
		System.out.println("definedPort=" + definedPort);
		String body = this.restTemplate.getForObject("/?a=RestTemplateTests", String.class);
		Assertions.assertThat(body).isEqualTo("Hello World err");
	}
}
