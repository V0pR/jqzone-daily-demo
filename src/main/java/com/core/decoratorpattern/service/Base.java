package com.core.decoratorpattern.service;

/**
 * @author wjq
 * @version 1.0
 * @Title: Base
 * @Package com.core.decoratorpattern.service.impl
 * @Description:
 * @date 2020/6/2 17:54
 */
@FunctionalInterface
public interface Base {

    default String description(){
        return  "unkonw description";
    };

     double cost();

}
