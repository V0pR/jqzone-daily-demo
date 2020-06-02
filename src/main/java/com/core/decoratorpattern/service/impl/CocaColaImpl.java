package com.core.decoratorpattern.service.impl;

import com.core.decoratorpattern.service.Base;

/**
 * @author wjq
 * @version 1.0
 * @Title: CocaColaImpl
 * @Package com.core.decoratorpattern.service.impl
 * @Description:
 * @date 2020/6/2 17:55
 */
public class CocaColaImpl implements Base {

    @Override
    public double cost() {
        System.err.println("Coca-Cola worth 5 rmb");
        return 5d;
    }
}
