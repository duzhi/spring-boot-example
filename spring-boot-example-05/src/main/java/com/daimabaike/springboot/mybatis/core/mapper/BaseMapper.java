package com.daimabaike.springboot.mybatis.core.mapper;

import java.util.List;

public interface BaseMapper<T, DTO> {

	T get(DTO id);
	T getById(Long id);
	int insert(T t);
	int update(T t);

	List<T> query(DTO t);
	
	List<T> queryAll(DTO t);

}
