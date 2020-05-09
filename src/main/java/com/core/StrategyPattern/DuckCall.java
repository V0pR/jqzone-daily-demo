package com.core.StrategyPattern;

import com.core.StrategyPattern.service.Fly;
import com.core.StrategyPattern.service.Quack;
import com.core.StrategyPattern.service.impl.FlyCall;
import com.core.StrategyPattern.service.impl.QuackCall;

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
