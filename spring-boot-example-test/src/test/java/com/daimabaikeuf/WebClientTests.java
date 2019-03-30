package com.daimabaikeuf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class WebClientTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void exampleTest2() {
		this.webClient.get().uri("/?a=WebClientTests").exchange().expectStatus().isOk().expectBody(String.class)
				.isEqualTo("Hello World err");
	}

}
