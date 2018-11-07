package com.daimabaike.springboot.mybatis.core.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

@Transactional(readOnly = true)
public class BaseService<D extends BaseMapper<T, DTO>, T extends BaseEntity<?>,DTO> {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected D dao;

	public T get(DTO id) {
		return dao.get(id);
	}

	public T queryForUpdateOne(DTO t) {
		List<T> list = this.queryForUpdate(t);
		if (list.isEmpty()) {
			return null;
		}
		if (list.size() > 1) {
			throw new RuntimeException("no one");
		}
		return list.get(0);
	}

	public List<T> queryForUpdate(DTO t) {
		return dao.queryForUpdate(t);
	}

}
