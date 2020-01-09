package com.core.domain;

import com.core.common.base.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjq
 * @version 1.0
 * @Title: User
 * @Package com.core.domain
 * @Description: 用户
 * @date 2020/1/9 16:58
 */
@Entity
@Table(name = "wj_user", uniqueConstraints = {})
public class User extends BaseDomain {
}
