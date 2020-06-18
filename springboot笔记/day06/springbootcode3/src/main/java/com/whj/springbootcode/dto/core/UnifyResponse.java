package com.whj.springbootcode.core;

public class UnifyResponse {
    private Integer code;
    private String massage;
    private String request; //接口地址

    public Integer getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }

    public String getRequest() {
        return request;
    }

    public UnifyResponse(int code, String massage, String request){
        this.code = code;
        this.massage = massage;
        this.request = request;
    }
}
