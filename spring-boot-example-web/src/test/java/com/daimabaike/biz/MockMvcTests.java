package com.daimabaike.biz;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.daimabaike.biz.sys.cons.XueliEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockMvcTests {

	@Autowired
	private MockMvc mvc;

	@Test(expected = IllegalArgumentException.class)
	public void example1Test() throws Exception {
		throw new IllegalArgumentException("aa");
	}

	@Test
	public void exampleTest() throws Exception {
		System.out.println(XueliEnum.aa.name());
		
		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.get("/sss"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());

		URL ul = new URL("http://www.a.cn:8101/sss");
		System.out.println(ul.getProtocol() + "-" + ul.getHost() + "-" + ul.getPort());

	}
}
