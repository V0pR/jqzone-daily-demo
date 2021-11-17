package com.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoXi
 * @Classname B
 * @Description TODO
 * @Date 2021/7/29 3:23 下午
 */
@Getter
@Setter
public class B {

    private C testC;


    public void b(){
        testC.c();
    }

}
