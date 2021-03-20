package com.core.service;

import com.core.domain.UserFeedBack;

import java.util.List;

/**
 * @author v0pr
 */
public interface UserFeedBackService {

    /**
     * 创建用户反馈记录
     * @param userFeedBack 创建信息
     */
    void create(UserFeedBack userFeedBack);

    /**
     * 列表
     * @return
     */
    List<UserFeedBack> findUserFeedBackList();
}
