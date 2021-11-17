package com.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoXi
 * @Classname b
 * @Description TODO
 * @Date 2021/7/6 10:05 上午
 */
@Getter
@Setter
public class C {
    private A testA;


    public void c(){
        testA.a();
    }
}
