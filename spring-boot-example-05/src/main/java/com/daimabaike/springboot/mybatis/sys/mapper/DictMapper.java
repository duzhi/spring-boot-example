package com.daimabaike.springboot.mybatis.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;

@Mapper
public interface DictMapper extends BaseMapper<Dict,Integer> {

	@Override
	@Select("select * from sys_dict where id=#{id}")
	Dict get(@Param("id") Integer id);

}
