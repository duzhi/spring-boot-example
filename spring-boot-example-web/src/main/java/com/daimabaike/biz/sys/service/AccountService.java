package com.daimabaike.biz.sys.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.daimabaike.biz.sys.entity.AccountVO;
import com.daimabaike.biz.sys.entity.UserDTO;

@Service
public class AccountService {

	
	public AccountVO query(UserDTO userDTO) {
		AccountVO vo = new AccountVO();
		
		Set<String> filterSet = new HashSet<>();
		
		vo.setId("1323");
		vo.setName("account");
		if(!filterSet.contains("email")) {
			vo.setEmail("aaa@111.com");
		}
//		if(1 == userDTO.getViewType()) {
//			vo.setEmail(null);
//		}
		
		vo.filter(userDTO.getFilter());
		
		return vo;
		
	}
	
}
