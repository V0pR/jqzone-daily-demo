package com.core.service;

import com.core.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author wjq
 * @version 1.0
 * @Title: UserService
 * @Package com.core.service
 * @Description:
 * @date 2020/1/10 14:06
 */
public interface UserService extends UserDetailsService {

    /**
     * create
     * @param user
     * @return
     */
    User create(User user);


    /**
     * 修改密码
     * @param userId
     * @param password
     */
    void updatePassword(Long userId, String password);

    /**
     * update
     * @param user
     */
    void update(User user);
}
