package com.core.StrategyPattern;

import com.core.StrategyPattern.service.Fly;
import com.core.StrategyPattern.service.Quack;
import com.core.StrategyPattern.service.impl.FlyCall;
import com.core.StrategyPattern.service.impl.QuackCall;

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
