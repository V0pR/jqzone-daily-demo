package com.core.domain.finder;

import com.core.domain.UserRoleRef;
import com.core.domain.query.QUser;
import com.core.domain.query.QUserRoleRef;
import io.ebean.Finder;

import java.util.List;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserRoleRefFinder
 * @Package com.core.domain.finder
 * @Description: TODO
 * @date 2020/3/17 23:31
 */
public class UserRoleRefFinder extends Finder<Long, UserRoleRef> {
    public UserRoleRefFinder() {
        super(UserRoleRef.class);
    }

    public UserRoleRefFinder(String databaseName) {
        super(UserRoleRef.class, databaseName);
    }

    public QUserRoleRef queryBean() {
        return new QUserRoleRef(db());
    }

    public List<UserRoleRef> findRoleByUserId(Long userId) {
        return this.queryBean()
                .where()
                .user.id.eq(userId).findList();

    }
}
