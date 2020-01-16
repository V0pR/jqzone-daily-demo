package com.core.domain.finder;

import com.core.domain.User;
import com.core.domain.query.QUser;
import io.ebean.Finder;

/**
 * @author wjq
 * @version 1.0
 * @Title: UserFinder
 * @Package com.core.domain.finder
 * @Description: userFinder
 * @date 2020/1/16 15:17
 */
public class UserFinder extends Finder<Long, User> {

    public UserFinder() {
        super(User.class);
    }

    public UserFinder(String databaseName) {
        super(User.class, databaseName);
    }

    public QUser queryBean() {
        return new QUser(db());
    }

    public User findById(Long userId) {
        return this.queryBean()
                .id.eq(userId).findOne();
    }
}

