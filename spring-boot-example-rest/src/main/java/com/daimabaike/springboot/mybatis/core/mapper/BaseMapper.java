package com.daimabaike.springboot.mybatis.core.mapper;

import java.util.List;

public interface BaseMapper<T> {

	T get(T id);

	T getById(Long id);

	int insert(T t);

	int update(T t);

	List<T> query(T t);

	List<T> queryAll(T t);

}
