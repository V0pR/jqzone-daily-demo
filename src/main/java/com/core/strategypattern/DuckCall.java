package com.core.strategypattern;

/**
 * @author wjq
 * @version 1.0
 * @Title: DuckCall
 * @Package com.core.StrategyPattern
 * @Description:
 * @date 2020/5/9 14:56
 */
public class DuckCall extends Duck {


    public DuckCall() {

    }

    @Override
    public void my() {
        System.err.println("my name is "+ DuckCall.class.getSimpleName());
    }
}
