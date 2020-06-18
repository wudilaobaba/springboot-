package com.whj.springbootcode.sample;

import com.whj.springbootcode.sample.database.IConnect;
import com.whj.springbootcode.sample.database.MySql;
import com.whj.springbootcode.sample.database.Oracel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfiguration {
    @Value("${mysql.ip}") //获取配置文件中的属性
    private String ip;

    @Value("${mysql.port}") //获取配置文件中的属性
    private Integer port;

    @Bean
    public IConnect mySql(){
        MySql mySql = new MySql();
        mySql.setPort(this.port);
        mySql.setIp(this.ip);
        return mySql;
    }
 }
