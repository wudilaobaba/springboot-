package com.whj.springbootcode.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过code码，再根据配置文件 config/exception-code.properties 来返回配置文件中的文件描述
 */
@ConfigurationProperties(prefix = "whj") //读取配置文件中的前缀
@PropertySource(value = "classpath:config/exception-code.properties") //将该类与.properties文件关联起来
@Component //必须加入容器才能与配置文件进行关联
public class ExceptionCodeConfiguration {
    private Map<Integer,String> codes = new HashMap<>(); //该变量名必须与配置文件中的名一致

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public String getMessage(int code){
        String message = codes.get(code);
        return message;
    }
}
