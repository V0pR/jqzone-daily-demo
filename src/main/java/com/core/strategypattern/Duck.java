package com.core.strategypattern;

import com.core.strategypattern.service.Fly;
import com.core.strategypattern.service.Quack;

/**
 * @author wjq
 * @version 1.0
 * @Title: Duck
 * @Package com.core.StrategyPattern.service
 * @Description:
 * @date 2020/5/9 13:57
 */
public abstract class Duck {
    Fly fly;
    Quack quack;

    public Duck() {
    }
    public void  fly(){
        fly.fly();
    }
    public void quack(){
        quack.quack();
    }
    public void setFlyObject(Fly f) {
        fly = f;
    }

    public void setQuackObject(Quack q) {
        quack = q;
    }

    public void my() {
        System.err.println("my name is" + Duck.class.getSimpleName());
    }


}
