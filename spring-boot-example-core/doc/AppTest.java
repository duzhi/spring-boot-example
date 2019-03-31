package com.daimabaike.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.daimabaike.mybatis.sys.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class AppTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void tes() {

		System.out.println(SeasonEnum.SUMMER.name());

		System.out.println(SeasonEnum.valueOf("WINTER"));

		System.out.println(SeasonEnum.SPRING.getSeasonSeq());

		System.out.println(SeasonEnum.getSeasonEnum(1));

		System.out.println(SeasonEnum.getSeasonEnum(2));

		System.out.println(SeasonEnum.getSeasonEnum(3));

		System.out.println(SeasonEnum.getSeasonEnum(4));

		System.out.println(SeasonEnum.getSeasonEnum(5));

	}

	@Test
	public void get() {
		Map<String, String> multiValueMap = new HashMap<>();
		multiValueMap.put("id", "test");
		User user = testRestTemplate.getForObject("/user/{id}", User.class, multiValueMap);
		Assert.assertEquals(user.getName(), "中文_1_1");
	}
}
