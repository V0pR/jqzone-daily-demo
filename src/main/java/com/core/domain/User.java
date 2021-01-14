package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.EmployeeStatus;
import com.core.domain.finder.UserFinder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author wangj
 * @version 1.0
 * @Title: User
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:47
 */
@Entity
@Data
@Builder
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone_number"})})
public class User extends BaseDomain {

    public static final UserFinder finder = new UserFinder();

    /**
     * 名字
     */
    private String name;
    /**
     * 昵称
     */
    private String nick;

    /**
     * 头像
     */
    private String avtUrl;
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private EmployeeStatus status;
}
