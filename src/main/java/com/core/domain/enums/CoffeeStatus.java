package com.core.domain.enums;

import io.ebean.annotation.EnumValue;

/**
 * @author wangj
 * @version 1.0
 * @Title: CoffeeStatus
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/16 23:35
 */
public enum CoffeeStatus {

    /**
     * ONLINE
     */
    @EnumValue("0")
    ONLINE,

    /**
     * OFFLINE
     */
    @EnumValue("1")
    OFFLINE;

}
