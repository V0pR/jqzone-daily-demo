package com.core.DemoCode.thread;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 11:44
 * @Description:
 */
public class RunA implements Runnable {
    @Override
    public void run() {

     try {
         int a = 1;
         int b = 0;

         int i = a / b;
         System.err.println(i);
     }catch (Exception e){
         System.err.println("我是一个run方法。我error了");
         e.printStackTrace();
     }
    }
}
