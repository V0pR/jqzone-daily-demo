package com.core.StrategyPattern.service.impl;

import com.core.StrategyPattern.service.Quack;
import org.springframework.stereotype.Service;

/**
 * @author wjq
 * @version 1.0
 * @Title: QuackImpl
 * @Package com.core.StrategyPattern.service.impl
 * @Description: quack
 * @date 2020/5/9 13:58
 */
@Service
public class QuackCall implements Quack {

    @Override
    public void quack() {
        System.err.println("duck call 蜂鸣");
    }
}
