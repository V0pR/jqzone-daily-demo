package com.core.domain.enums;

import io.ebean.annotation.EnumValue;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserStatus
 * @Package com.core.domain.enums
 * @Description: TODO
 * @date 2020/3/16 23:41
 */
public enum EmployeeStatus {

    /**
     * 待完善
     */
    @EnumValue("0")
    INIT,

    /**
     * 正常
     */
    @EnumValue("1")
    NORMAL,

    /**
     * 锁定
     */
    @EnumValue("2")
    LOCKED;
}
