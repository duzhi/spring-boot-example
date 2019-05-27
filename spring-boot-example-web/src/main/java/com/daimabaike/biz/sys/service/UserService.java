package com.daimabaike.biz.sys.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.daimabaike.biz.sys.entity.User;

public interface UserService {
	
    @Cached(name="userCache-", key="#userId", expire = 3600)
    User getUserById(long userId);

    @CacheUpdate(name="userCache-", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="userCache-", key="#userId")
    void deleteUser(long userId);

}
