package com.core.decoratorpattern.service;

import com.core.decoratorpattern.service.impl.Condiment;

/**
 * @author wjq
 * @version 1.0
 * @Title: Mocha
 * @Package com.core.decoratorpattern.service
 * @Description:
 * @date 2020/6/3 17:57
 */
public class Decorator extends Condiment {
    Base base;

    Decorator(Base base1){
        this.base =base1;
    }

    @Override
    public String description() {
        return super.description()+"mocha";
    }

    @Override
    public double cost() {
        double cost = base.cost();
        return 5.99d + cost;
    }
}
