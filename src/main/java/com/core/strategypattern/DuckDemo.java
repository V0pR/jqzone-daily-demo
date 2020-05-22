package com.core.strategypattern;

import com.core.strategypattern.service.impl.FlyCall;
import com.core.strategypattern.service.impl.QuackCall;

/**
 * @author wjq
 * @version 1.0
 * @Title: DuckDemo
 * @Package com.core.controller
 * @Description:
 * @date 2020/5/9 14:12
 */
public class DuckDemo {
    public static void main(String[] args) {
        Duck duck = new DuckCall();
        duck.setFlyObject(new FlyCall());
        duck.setQuackObject(new QuackCall());
        duck.fly();
        duck.quack();
        duck.my();

    }
}
