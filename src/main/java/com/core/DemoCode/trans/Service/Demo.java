package com.core.DemoCode.trans.Service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 19:32
 * @Description:
 */
public class Demo {


    ServiceA serviceA;

    ServiceB serviceB;


    public void demo() {
        int a=1;
        serviceA.service1A(a);
        System.err.println(a);
    }
}
