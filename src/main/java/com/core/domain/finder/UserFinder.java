package com.core.domain.finder;

import com.core.domain.User;
import com.core.domain.query.QUser;
import io.ebean.Finder;

import java.util.Optional;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserFinder
 * @Package com.core.domain.finder
 * @Description: TODO
 * @date 2020/3/17 22:40
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

    public Optional<User> findByAccount(String account) {
        return this.queryBean()
                .where()
                .account.eq(account)
                .findOneOrEmpty();
    }

    public Optional<User> findByUserId(String accountId) {
        return this.queryBean()
                .where()
                .account.eq(accountId)
                .findOneOrEmpty();
    }
}
