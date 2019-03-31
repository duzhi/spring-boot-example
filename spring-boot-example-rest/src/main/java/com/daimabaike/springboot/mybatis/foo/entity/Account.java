package com.daimabaike.springboot.mybatis.foo.entity;

import java.math.BigInteger;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;

public class Account extends BaseEntity{

	private BigInteger balance;

	public BigInteger getBalance() {
		return balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
	
}
