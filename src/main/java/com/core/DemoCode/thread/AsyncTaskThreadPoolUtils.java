package com.core.DemoCode.thread;



import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 公共线程池类
 *
 * @author WJQ
 */
public enum AsyncTaskThreadPoolUtils {

    /**
     * 实例
     */
    INSTANCE;

    private static final ThreadPoolExecutor commonThreadPool;

    static {
        commonThreadPool = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 获取实例
     *
     * @return ThreadPoolExecutor 线程池
     */
    public ThreadPoolExecutor getInstance() {
        return commonThreadPool;
    }

    /**
     * 获取实例
     *
     * @param busyRefuse 繁忙是否拒绝
     * @return ThreadPoolExecutor 线程池
     */
    public ThreadPoolExecutor getInstance(boolean busyRefuse) {
        return commonThreadPool;
    }


}
