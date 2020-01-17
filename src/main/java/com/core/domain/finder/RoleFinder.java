package com.core.domain.finder;

import com.core.domain.Role;
import com.core.domain.query.QRole;
import io.ebean.Finder;

/**
 * @author wjq
 * @version 1.0
 * @Title: RoleFinder
 * @Package com.core.domain.finder
 * @Description:
 * @date 2020/1/17 14:24
 */
public class RoleFinder extends Finder<Long, Role> {

    public RoleFinder() {
        super(Role.class);
    }

    public RoleFinder(String databaseName) {
        super(Role.class, databaseName);
    }

    public QRole queryBean() {
        return new QRole(db());
    }

    public Role findById(Long roleId){
        return this.queryBean()
                .id.eq(roleId).findOne();
    }


}
