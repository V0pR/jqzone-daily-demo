package com.core.domain;

import com.core.common.base.BaseDomain;
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
@Table(name = "wj_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"account", "phone_number"})})
public class User extends BaseDomain {

    /**
     * 用户
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 账号
     */
    private String account;

    /**
     * salt
     */
    private String salt;

    /**
     * 密码
     */
    private String password;
}
