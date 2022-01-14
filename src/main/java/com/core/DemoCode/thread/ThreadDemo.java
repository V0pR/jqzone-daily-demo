package com.core.DemoCode.thread;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 11:45
 * @Description:
 */
public class ThreadDemo {


    public static void main(String[] args) {

        try {
            AsyncTaskThreadPoolUtils.INSTANCE.getInstance().execute(new RunA());
        }catch (Exception e){
            System.err.println("我被e了");
        }
    }
}
