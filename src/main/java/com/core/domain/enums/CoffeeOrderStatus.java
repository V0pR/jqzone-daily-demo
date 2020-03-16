package com.core.domain.enums;

import io.ebean.annotation.EnumValue;

/**
 * @author wangj
 * @version 1.0
 * @Title: CoffeeOrderStatus
 * @Package com.core.domain.enums
 * @Description: TODO
 * @date 2020/3/16 23:37
 */
public enum CoffeeOrderStatus {

    /**
     * WAIT
     */
    @EnumValue("0")
    WAIT,

    /**
     * HAVE_ORDER
     */
    @EnumValue("1")
    HAVE_ORDER,

    /**
     * 配送中
     */
    @EnumValue("2")
    DISTRIBUTION,

    /**
     * 完成
     */
    @EnumValue("3")
    DONE,

    /**
     * 关闭
     */
    @EnumValue("4")
    CLOSE,

    /**
     * 取消
     */
    @EnumValue("5")
    CANCEL,

    /**
     * 异常
     */
    @EnumValue("6")
    EXCEPTION;
}
