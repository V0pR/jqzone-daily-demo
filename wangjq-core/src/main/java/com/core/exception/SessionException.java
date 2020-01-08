package com.core.exception;

/**
 * @author longfei.zhao
 * @Description: session异常
 * @date 2017/12/30
 */
public class SessionException extends RuntimeException {

    public SessionException() {
        super("未知错误");
    }

    public SessionException(String message) {
        super(message);
    }
}
