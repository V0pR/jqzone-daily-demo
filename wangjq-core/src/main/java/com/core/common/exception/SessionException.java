package com.core.common.exception;

/**
 * @author wjq
 * @Description: session异常
 * @date 2020-01-09 16:56:18
 */
public class SessionException extends RuntimeException {

    public SessionException() {
        super("未知错误");
    }

    public SessionException(String message) {
        super(message);
    }
}
