package com.core.DemoCode.thread;

/**
 * @Author: jq.w
 * @Date: 2021/11/17 11:45
 * @Description:
 */
public class ThreadDemo {


    public static void main(String[] args) {


        AsyncTaskThreadPoolUtils.INSTANCE.getInstance().execute(new RunA());

    }
}
