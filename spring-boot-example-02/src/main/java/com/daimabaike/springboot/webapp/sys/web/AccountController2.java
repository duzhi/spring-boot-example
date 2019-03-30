package com.daimabaike.springboot.webapp.sys.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.daimabaike.springboot.webapp.common.BizException;
import com.daimabaike.springboot.webapp.common.Result;
import com.daimabaike.springboot.webapp.common.ResultUtils;
import com.daimabaike.springboot.webapp.common.web.BaseController;
import com.daimabaike.springboot.webapp.sys.vo.AccountVO;

//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;

@Controller
public class AccountController2 extends BaseController{

	@Autowired
	RestTemplate restTemplate;
	
    protected WebClient webClient = WebClient.builder().baseUrl("").build();

    @RequestMapping(value="bizex/time" )
    @ResponseBody
	public AccountVO bizex(int id) {
		
		System.out.println("bizex");
		
		// get filter 
		// 
		
		
		
		
		if(id == 0) {
			BizException ex = new BizException();
			ex.setStatus(400);
			ex.setCode("zero");
			ex.setMessage("zero error");
			throw ex;
		}
		AccountVO vo = new AccountVO();
		vo.setId("test-" + id);
		vo.setCreateTime(new Date());
		
//		vo.filter(fn);
		
		return vo;
	}
    
	@RequestMapping(value="login",produces= {"text/html;charset=UTF-8"} )
	public String login() {
		
		System.out.println("login abcd page");
		
		return "login";
	}
	
	@RequestMapping(value = "api/{time}")
	@ResponseBody
	public Result<Object> restapi(@PathVariable String time) {

		System.out.println("login abcd page");

//		restTemplate.getRequestFactory().
		String r =
			 restTemplate.getForObject("http://localhost:8000/sys/users?time=" + time, String.class);

//		String r = restTemplate.getForObject("https://www.jianshu.com/p/4aaae49c8221", String.class);
		
//		Mono.fromCallable(() -> restTemplate.getForObject("" + "/hello/", String.class))
//				.subscribeOn(Schedulers.elastic());
//
//		Mono<String> mono = webClient.get().uri("/hello/").exchange()
//				.flatMap(clientResponse -> clientResponse.bodyToMono(String.class));
//
//		mono.block();

		return ResultUtils.ok(r);
	}

	@RequestMapping(value="err500")
	@ResponseBody
	public Result<Void> restapi500() {
		
		System.out.println("login abcd 500");
		
		
//		MsgData<TestBody> data = JSON.parseObject(json,);

//		Result<Void> a = new TypeReference<Result<Void>>(){}.getClass();
		
//		return restTemplate.getForObject("http://localhost:8000/sys/error500", String.class);
		
//		return
		try {
			String resp = restTemplate.getForObject("http://localhost:8000/sys/error500", String.class);
			return JSONObject.parseObject(resp, new TypeReference<Result<Void>>(){});
		}catch(HttpServerErrorException e) {
			e.getResponseBodyAsString();
			
		}catch(RestClientException e) {
			e.printStackTrace();
		}
return null;
	}
	
	@RequestMapping(value="err400")
	@ResponseBody
	public Result<Void> restapi400() {
		
		System.out.println("login abcd 400");
		
		String resp = restTemplate.getForObject("http://localhost:8000/sys/error400", String.class);
		return JSONObject.parseObject(resp, new TypeReference<Result<Void>>(){});
	}
}