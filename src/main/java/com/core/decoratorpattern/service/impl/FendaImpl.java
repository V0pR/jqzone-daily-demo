package com.core.decoratorpattern.service.impl;

import com.core.decoratorpattern.service.Base;

/**
 * @author wjq
 * @version 1.0
 * @Title: FendaImpl
 * @Package com.core.decoratorpattern.service.impl
 * @Description:
 * @date 2020/6/3 11:19
 */
public class FendaImpl implements Base {
    @Override
    public double cost() {

        System.err.println("this is fenda");
        return 2.99d;
    }
}
