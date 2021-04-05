package com.core.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AsyncNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 投递简历，插入投递记录
        TimeUnit.SECONDS.sleep(2);
        log.info("插入投递记录完毕...");

        // 异步发送短信通知HR，并留存发送记录
        CompletableFuture.runAsync(() -> {
            try {
                notifyHR("bravo1988", "叉车师傅");
                writeMsg("bravo1988", "叉车师傅");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("耗时:{}毫秒", System.currentTimeMillis() - start);

        // 为了观察到异步线程里的打印信息，主线程sleep一会儿
        TimeUnit.SECONDS.sleep(2);
    }

    public static void notifyHR(String username, String jobName) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("【发送消息】HR你好，用户:{}, 投递你的岗位:{}", username, jobName);
    }

    public static void writeMsg(String username, String jobName) {
        // 留存消息发送记录
        log.info("【保存消息】保存到数据库, 用户:{}, 岗位:{}", username, jobName);
    }
}
