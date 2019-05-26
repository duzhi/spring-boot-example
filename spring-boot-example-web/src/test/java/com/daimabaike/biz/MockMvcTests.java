package com.daimabaike.biz;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class MockMvcTests {

//	@Autowired
//	private MockMvc mvc;

	@Test(expected = IllegalArgumentException.class)
	public void example1Test() throws Exception {
		throw new IllegalArgumentException("aa");
	}

	@Test
	public void exampleTest() throws Exception {
		assertTrue(Integer.TYPE.isPrimitive());
		
		
		
			
//		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.get("/sss"))
//				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//		System.out.println(result.getResponse().getContentAsString());
//
//		URL ul = new URL("http://www.a.cn:8101/sss");
//		System.out.println(ul.getProtocol() + "-" + ul.getHost() + "-" + ul.getPort());

	}
}
