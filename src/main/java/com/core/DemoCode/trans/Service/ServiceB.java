package com.core.DemoCode.trans.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 19:32
 * @Description:
 */
@Service("serviceB")
public class ServiceB {
    @Transactional(rollbackFor = Exception.class)
    public void service2(int a){
        System.err.println("im"+this.getClass());
        int i = 1 / a;
        System.err.println(i);
    }
}
