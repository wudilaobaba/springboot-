package com.whj.springbootcode.exception.http;

/**
 * 自定义异常的基类
 */
public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
