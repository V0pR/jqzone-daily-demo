package com.core.DemoCode.thread;

import com.core.DemoCode.trans.Service.ServiceA;
import com.core.DemoCode.trans.Service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 11:44
 * @Description:
 */
public class RunA implements Runnable {
    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceB serviceB;

    @Override
    public void run() {

     try {
         serviceA.service1A(1);

     }catch (Exception e){
         System.err.println("我是一个run方法。我error了+"+this.getClass());
         e.printStackTrace();
     }
    }
}
