package com.whj.springbootcode.exception.http;

/**
 * 被禁用的，没有权限的异常
 */
public class ForbiddenException extends HttpException{
    public ForbiddenException(int code){
        this.httpStatusCode = 403;
        this.code = code;
    }
}
