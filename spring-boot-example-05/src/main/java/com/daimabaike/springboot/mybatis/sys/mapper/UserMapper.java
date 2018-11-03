package com.daimabaike.springboot.mybatis.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.daimabaike.springboot.mybatis.core.mapper.BaseMapper;
import com.daimabaike.springboot.mybatis.sys.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User,String> {

//	@Override
	@Select("select * from user where id=#{id}")
	User get(@Param("id") String id);

	@Select("select sleep(#{time}) as 'time' from dual")
	int find(int time);

	// for update 没有索引的字段，会全表锁住。如果不了解细节，慎用。建议查询条件是唯一键字段（含主键）才使用
	@Override
	@Select("select * from user where name=#{name} for update")
	List<User> queryForUpdate(User user) ;
	
	@Update("")
	void savePic();
}
