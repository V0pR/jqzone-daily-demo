package com.core.domain;

import com.core.common.base.BaseRefDomain;
import com.core.domain.finder.UserFinder;
import com.core.domain.finder.UserRoleRefFinder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserRoleRef
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/17 22:24
 */
@Entity
@Table
@Builder
@Data
public class UserRoleRef extends BaseRefDomain {

    public static final UserRoleRefFinder finder = new UserRoleRefFinder();

    /**
     * 用户
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    /**
     * 角色
     */

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;


}
