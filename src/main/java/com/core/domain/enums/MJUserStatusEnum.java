package com.core.domain.enums;

import io.ebean.annotation.EnumValue;

/**
 * @author wjq
 * @version 1.0
 * @Title: MJUserStatusEnum
 * @Package com.core.domain.enums
 * @Description: 用户状态
 * @date 2020/1/16 10:59
 */
public enum MJUserStatusEnum {

    /**
     * 初始化
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
    @EnumValue("3")
    LOCK,

    /**
     * 黑名单
     */
    @EnumValue("4")
    black;








}
