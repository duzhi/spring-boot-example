package com.daimabaike.springboot.mybatis.sys.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {

	// Dict get(DictDto dictDto);

}
