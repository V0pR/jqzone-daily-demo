package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.MJUserStatusEnum;
import com.core.domain.finder.UserFinder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author wjq
 * @version 1.0
 * @Title: User
 * @Package com.core.domain
 * @Description: 用户
 * @date 2020/1/9 16:58
 */
@Data
@Builder
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "phone_number"})})
public class User extends BaseDomain {


    public static final UserFinder finder = new UserFinder();

    /**
     * 用户
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * status
     */
    private MJUserStatusEnum status;
}
