package com.core.domain.finder;

import com.core.domain.User;
import com.core.domain.UserRoleRef;
import com.core.domain.query.QUser;
import com.core.domain.query.QUserRoleRef;
import io.ebean.Finder;

import java.util.List;

/**
 * @author wjq
 * @version 1.0
 * @Title: UserRoleRefFinder
 * @Package com.core.domain.finder
 * @Description:
 * @date 2020/1/17 14:29
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

    public List<UserRoleRef> findById(Long userId) {
        return this.queryBean()
                .user.id.eq(userId).findList();
    }
}
