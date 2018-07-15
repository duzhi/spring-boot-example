package com.daimabaike.springboot.mybatis.core.dao;

public interface BaseDao<T,ID> {

	default T get(ID id) {
		throw new UnsupportedOperationException("get");
	}
	
}
