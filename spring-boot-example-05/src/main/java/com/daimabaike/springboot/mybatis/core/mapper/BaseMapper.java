package com.daimabaike.springboot.mybatis.core.mapper;

import java.util.List;

public interface BaseMapper<T, ID> {

	default T getById(ID id) {
		throw new UnsupportedOperationException("get");
	}
	
//	default T get(ID id) {
//		throw new UnsupportedOperationException("get");
//	}
	
	default T get(T id) {
		throw new UnsupportedOperationException("get");
	}
	
	default int save(T t) {
		throw new UnsupportedOperationException("save");
	}

	default List<T> queryForUpdate(T t) {
		throw new UnsupportedOperationException("queryForUpdate");
	}
	
	
	
	
}
