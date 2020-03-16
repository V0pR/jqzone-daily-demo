package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

import javax.naming.Name;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: User
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:47
 */
@Entity
@Table
@Builder
public class User extends BaseDomain {

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
     * 电话
     */
    private String phoneNo;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private UserStatus status;

    /**
     * 是否是VIP
     */
    private boolean hasVip;


}
