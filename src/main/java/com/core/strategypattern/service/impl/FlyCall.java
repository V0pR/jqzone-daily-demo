package com.core.strategypattern.service.impl;

import com.core.strategypattern.service.Fly;
import org.springframework.stereotype.Service;

/**
 * @author wjq
 * @version 1.0
 * @Title: FlyCall
 * @Package com.core.StrategyPattern.service.impl
 * @Description:
 * @date 2020/5/9 13:58
 */
@Service
public class FlyCall implements Fly {

    @Override
    public void fly() {
        System.err.println("no, i cant");
    }
}
