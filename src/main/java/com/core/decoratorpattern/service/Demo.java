package com.core.decoratorpattern.service;

import com.core.decoratorpattern.service.impl.BaishiImpl;

/**
 * @author wjq
 * @version 1.0
 * @Title: Demo
 * @Package com.core
 * @Description:
 * @date 2020/6/2 17:53
 */
public class Demo {

    public static void main(String[] args) {
        //可乐
        Base base = new Decorator(new BaishiImpl());
        System.out.println(base.description());
        System.out.println(base.cost());

        //可乐+mocha
        base = new Decorator(base);
        System.out.println(base.cost());
        System.out.println(base.description());

    }
}
