package com.daimabaike.biz.foo.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.foo.dto.BarDTO;
import com.daimabaike.biz.foo.entity.DailyData;
import com.daimabaike.biz.foo.service.BarService;

@RequestMapping("bar")
@RestController
public class BarController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Bean("strTestBar")
	public String createA() {
		logger.info("strTestBar");
		return "strTestBarrggr";
	}
	
	@Autowired
	BarService barService;
	
	@Autowired
    @Qualifier("strTestBar")
	String sss;

	@RequestMapping(value = "query")
	public String test(@RequestBody BarDTO dto) {

		if (dto.getType() == 2) {
			throw new RuntimeException();
		}

		return dto.toString();
	}

	@GetMapping("name")
	public Result<String> name() {

		// service1

		// service2
		Result<String> r = new Result<>();
		try {
			barService.order();
			r.setData("12311");
		} catch (Exception e) {
			r.setData("ex:" + e.getMessage());
		}
		return r;
	}
	
	@GetMapping("biz")
	public Map<String,Object> biz() {
		logger.info("biz");
		
		Map<String,Object> result = new HashMap<>();
		
		result.put("data", new DailyData());
		
		// exception
		return result;
		
	}
	
	@GetMapping("/{name}")
	public Result<DailyData> xxxx(HttpServletRequest request) {
		logger.info("biz");
		
        StringBuilder sb = new StringBuilder();
        
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }catch (Exception e) {
        	e.printStackTrace();
		}
        
		logger.info("sb:" + sb.toString());
		
		Result<DailyData> r=new Result<DailyData>();
		DailyData d=new DailyData();
d.setName("zzz");
d.setAge(112);
		r.setData(d);
//		result.put("data", new DailyData());
		
		
		// get controller
		
		
		// exception
		return r;
		
	}
	
}
