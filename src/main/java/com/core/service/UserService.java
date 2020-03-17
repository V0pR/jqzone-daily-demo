package com.core.service;

import com.core.common.base.BaseService;
import com.core.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserService
 * @Package com.core.service
 * @Description: TODO
 * @date 2020/3/17 0:21
 */
public interface UserService extends UserDetailsService {
    /**
     * 创建用户
     * @param user
     */
    void registered(User user);
}
