package com.daimabaike.springboot.mybatis.core.dao;

import java.util.List;

public interface BaseDao<T, ID> {

	default T get(ID id) {
		throw new UnsupportedOperationException("get");
	}

	default int save(T t) {
		throw new UnsupportedOperationException("save");
	}

	default List<T> queryForUpdate(T t) {
		throw new UnsupportedOperationException("queryForUpdate");
	}
}
