package com.daimabaike.core.sys.service;

import java.util.Arrays;
import java.util.List;

//import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.daimabaike.core.sys.entity.Dict;

//@CacheConfig
@Service
public class SysCacheService {//implements SysCache
	
	
//	public List<Dict> query1111(String key){
//		
//	}
	
	
//	, keyGenerator = "XKeyGenerator"
//	@Override
	@Cacheable(value = "sys",keyGenerator="dsdada")
	public List<Dict> query(String key){
		
		System.out.println("SysCacheService.query");
		return Arrays.asList(new Dict[] {new Dict()});
	}
	
//	@Override
	@Cacheable(value = "sys",key="#key")
	public Dict query11(String key){
		
		System.out.println("SysCacheService.query11");
		
		Dict dict = new Dict();
		dict.setCode("aaa");
		dict.setType("channel");
		return dict;
	}
}
