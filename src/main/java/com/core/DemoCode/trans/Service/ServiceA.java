package com.core.DemoCode.trans.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 19:32
 * @Description:
 */
@Service("serviceA")
public class ServiceA {

    @Autowired
    ServiceB serviceB;

    //@Transactional(rollbackFor = Exception.class)
    public void service1A(int a){
        System.err.println("im"+this.getClass());
        serviceB.service2( a);

    }
}
