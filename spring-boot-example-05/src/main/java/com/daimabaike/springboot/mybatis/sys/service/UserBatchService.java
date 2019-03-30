package com.daimabaike.springboot.mybatis.sys.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daimabaike.springboot.mybatis.sys.entity.User;
import com.daimabaike.springboot.mybatis.sys.mapper.UserMapper;

@Service
public class UserBatchService {

	@Autowired
	SqlSessionFactory SqlSessionFactory;

	@Transactional
	public int doBiz() {

		SqlSession sqlSession = SqlSessionFactory.openSession(ExecutorType.BATCH, false);
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
//		userMapper.
		
		int num = 0;
		try {
			int prx = SecureRandom.getInstanceStrong().nextInt(10000);
			for (int i = 0; i < 10000; i++) {
				User user = new User();

				user.setId(System.currentTimeMillis() + SecureRandom.getInstanceStrong().nextInt(1000));

				user.setName(("duqi-" + prx) + i);
				
//				if(i == 99) {
//					user.setTel("opiiiiiiidwdwidwidwdwdwdwd");
//				}
				
				int the = userMapper.insert(user);
				System.out.println("succ:" + the);
				num += the;
				if (i % 100 == 99) {
					System.out.println("commit at "+i);
					sqlSession.commit();
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
		
	//	sqlSession.rollback();
		return num;
	}

}
