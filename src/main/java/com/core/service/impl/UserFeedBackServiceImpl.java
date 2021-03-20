package com.core.service.impl;

import com.core.domain.UserFeedBack;
import com.core.service.UserFeedBackService;
import io.ebean.DB;
import io.ebean.Ebean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author v0pr
 */
@Service("userFeedBackService")
public class UserFeedBackServiceImpl implements UserFeedBackService {

    @Override
    public void create(UserFeedBack userFeedBack) {
        DB.insert(userFeedBack);
    }

    @Override
    public List<UserFeedBack> findUserFeedBackList() {
        return DB.find(UserFeedBack.class)
                .findList();
    }
}
