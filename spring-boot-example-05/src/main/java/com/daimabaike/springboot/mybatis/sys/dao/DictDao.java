package com.daimabaike.springboot.mybatis.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daimabaike.springboot.mybatis.core.dao.BaseDao;
import com.daimabaike.springboot.mybatis.sys.entity.Dict;

@Mapper
public interface DictDao extends BaseDao<Dict,Integer> {

	@Override
	@Select("select * from sys_dict where id=#{id}")
	Dict get(@Param("id") Integer id);

}
