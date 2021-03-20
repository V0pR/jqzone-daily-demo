package com.core.service;

import com.core.domain.UserFeedBack;

public interface UserFeedBackService {

    /**
     * 创建用户反馈记录
     * @param userFeedBack 创建信息
     */
    void create(UserFeedBack userFeedBack);
}
