package com.daimabaike.spring.session.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

@Service
public class RedisOpsServiceImpl implements RedisOpsService {

	@Autowired
	private RedisTemplate<String, String> template;

	public String aaa(String id) {

		final List<String> lis = new ArrayList<String>();
		Long re = template.execute(s, lis, new Object[] {});

		return re + "";
	}

	static final RedisScript<Long> s = new RedisScript<Long>() {

		@Value("${app.script.sha1}")
		private String sha1;

		@Override
		public String getSha1() {
			System.out.println("sha1," + sha1);
			return "a2eba4a6e7d6643bc4b14aa4f9e0eedd55dbae3d";
		}

		@Override
		public Class<Long> getResultType() {
			return Long.class;
		}

		@Override
		public String getScriptAsString() {
			System.out.println("getScriptAsString," + null);
			return null;
		}

	};
}
