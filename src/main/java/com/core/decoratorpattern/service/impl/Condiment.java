package com.core.decoratorpattern.service.impl;

import com.core.decoratorpattern.service.Base;

/**
 * @author wjq
 * @version 1.0
 * @Title: MatchingCondiment
 * @Package com.core.decoratorpattern.service.impl
 * @Description:
 * @date 2020/6/2 18:03
 */
public class Condiment implements Base {
    @Override
    public double cost() {
        System.err.println("冰块价值1元");
        return 1d;
    }

    @Override
    public String description() {
        System.err.println("我是冰");
        return "ice";
    }
}
