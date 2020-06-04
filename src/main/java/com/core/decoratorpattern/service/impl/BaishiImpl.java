package com.core.decoratorpattern.service.impl;

import com.core.decoratorpattern.service.Base;

/**
 * @author wjq
 * @version 1.0
 * @Title: BaishiImpl
 * @Package com.core.decoratorpattern.service.impl
 * @Description:
 * @date 2020/6/3 11:20
 */
public class BaishiImpl implements Base {
    @Override
    public double cost() {
        return 3.99d;
    }
}
