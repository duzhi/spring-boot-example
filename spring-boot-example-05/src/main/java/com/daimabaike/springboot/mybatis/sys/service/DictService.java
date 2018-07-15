package com.daimabaike.springboot.mybatis.sys.service;

import org.springframework.stereotype.Service;

import com.daimabaike.springboot.mybatis.core.service.BaseService;
import com.daimabaike.springboot.mybatis.sys.dao.DictDao;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;

@Service
public class DictService extends BaseService<DictDao,Dict,Integer>{

}
