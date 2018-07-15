package com.daimabaike.springboot.mybatis.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.daimabaike.springboot.mybatis.core.dao.BaseDao;
import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class BaseService<D extends BaseDao<T,ID>, T extends BaseEntity<ID>, ID extends Serializable> {

	@Autowired
	protected D dao;
	
	public T get(ID id) {
		return dao.get(id);
	}
}
