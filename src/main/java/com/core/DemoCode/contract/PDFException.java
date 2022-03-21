package com.core.DemoCode.contract;

/**
 * @Author: jq.w
 * @Date: 2022/3/7 10:49
 * @Description:
 */
public class PDFException extends RuntimeException{
    public PDFException(String message, Throwable cause) {
        super(message, cause);
    }
}
