package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.mapper.DictMapper;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;

@Service
public class DictService extends BaseService<DictMapper,Dict,Integer>{

}
