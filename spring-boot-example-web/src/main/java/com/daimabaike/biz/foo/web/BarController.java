package com.daimabaike.biz.foo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.foo.dto.BarDTO;

@RequestMapping("bar")
@RestController
public class BarController extends BaseController{

	
	@RequestMapping(value="query")
	public String test(@RequestBody BarDTO dto) {
		
		if(dto.getType() == 2) {
			throw new RuntimeException();
		}
		
//		Result<String> r = new Result<>();
//		
//		r.setCode(0);
//		r.setMessage("OK");
//		r.setData(dto.toString());
		
		return dto.toString();
	}
	
	@GetMapping("name/{channelId}/{type}")
	public Result<BarDTO> name(BarDTO dto) {
		
		Result<BarDTO> r = new Result<>();
		
		r.setCode(0);
		r.setMessage("OK");
		r.setData(dto);
		
		return r;
	}
}
