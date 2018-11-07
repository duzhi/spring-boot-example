package com.daimabaike.springboot.mybatis.core.mapper;

import java.util.List;

public interface BaseMapper<T, DTO> {

	// default T getById(ID id) {
	// throw new UnsupportedOperationException("get");
	// }

	default T get(DTO id) {
		throw new UnsupportedOperationException("get");
	}

	default int save(DTO t) {
		throw new UnsupportedOperationException("save");
	}

	default List<T> queryForUpdate(DTO t) {
		throw new UnsupportedOperationException("queryForUpdate");
	}
}
