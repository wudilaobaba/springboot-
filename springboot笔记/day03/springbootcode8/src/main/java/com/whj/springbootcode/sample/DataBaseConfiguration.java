package com.whj.springbootcode.sample;

import com.whj.springbootcode.sample.database.MySql;
import com.whj.springbootcode.sample.database.Oracle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfiguration {
    @Value("${mysql.ip}")
    private String ip;

    @Value("${mysql.port}")
    private Integer port;

    @Bean
    @ConditionalOnBean(name="m")
    public IConnect m(){
        MySql mySql = new MySql();
        mySql.setIp(this.ip);
        mySql.setPort(this.port);
        return mySql;
    }

    @Bean
    public IConnect o(){
        Oracle oracle = new Oracle();
        oracle.setIp(this.ip);
        oracle.setPort(this.port);
        return oracle;
    }
}
