package com.daimabaike.springboot.mybatis.core.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

@Transactional(readOnly = true)
public class BaseService<DAO extends BaseMapper<T>, T extends BaseEntity> {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected DAO dao;
	
	public T get(T id) {
		return dao.get(id);
	}
	@Transactional
	public int update(T u) {
		return dao.update(u );
	}
	public T queryForUpdateOne(T t) {
		List<T> list = this.query(t);
		if (list.isEmpty()) {
			return null;
		}
		if (list.size() > 1) {
			throw new RuntimeException("no one");
		}
		return list.get(0);
	}

	public List<T> query(T t) {
		return dao.query(t);
	}

}
