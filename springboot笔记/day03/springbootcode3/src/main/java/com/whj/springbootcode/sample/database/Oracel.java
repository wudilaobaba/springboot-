package com.whj.springbootcode.sample.database;

public class Oracel implements IConnect{

    private String ip;
    private Integer port;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println(this.ip+":"+this.port);
    }
}
