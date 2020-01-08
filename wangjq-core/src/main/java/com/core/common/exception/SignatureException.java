package com.core.common.exception;

/**
 * @author wjq
 */
public class SignatureException extends RuntimeException {

    public SignatureException() {
        super("未知错误");
    }

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignatureException(Throwable cause) {
        super(cause);
    }
}
