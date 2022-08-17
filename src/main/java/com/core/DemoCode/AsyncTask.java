package com.core.DemoCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @Author: jq.w
 * @Date: 2022/4/15 11:10
 * @Description:
 */
@Component
@Slf4j
public class AsyncTask {

    @Async
    public void exec() throws Exception{
        log.info("thrId:{}",Thread.currentThread().getId());
        System.out.println("准备睡觉:" + System.currentTimeMillis());
        Thread.sleep(10);
        System.out.println("醒了");
    }

    @Async
    public AsyncResult<String> exec2() throws Exception{
        log.info("thrId:{}",Thread.currentThread().getId());
        System.out.println("准备睡觉:" + System.currentTimeMillis());
        Thread.sleep(10);
        System.out.println("醒了");
        return new AsyncResult<String>("有力气了");
    }

}
