package com.daimabaike.webflux.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.daimabaike.webflux.entity.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String>{
    // 2
	Mono<User> findByName(String name);

}
