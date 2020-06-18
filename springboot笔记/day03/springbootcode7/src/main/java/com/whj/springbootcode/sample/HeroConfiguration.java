package com.whj.springbootcode.sample;

import com.whj.springbootcode.sample.condition.DinanaCondition;
import com.whj.springbootcode.sample.condition.IreliaCondition;
import com.whj.springbootcode.sample.hero.Camille;
import com.whj.springbootcode.sample.hero.Dinana;
import com.whj.springbootcode.sample.hero.Irelia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Value("${mysql.ip}")
    private String ip;

    @Value("${mysql.port}")
    private Integer port;

    @Bean
    @ConditionalOnProperty(value="hero.condition嗯嗯",  havingValue = "dinana", matchIfMissing = true)
    //value是配置文件中的属性,havingValue是判断值是否是dinana，符合条件，则加入容器
    //matchIfMissing 如果在配置文件中没有找到hero.condition，那么会将有matchIfMissing = true的bean加入到容器
    public ISkill qwe(){
        Dinana dinana = new Dinana();
        dinana.setIp(this.ip);
        dinana.setPort(this.port);
        return dinana;
    }

    @Bean
    @ConditionalOnProperty(value="hero.condition嗯嗯",  havingValue = "irelia")//value是配置文件中的属性,havingValue是判断值是否是irelia，符合条件，则加入容器
    public ISkill i(){
        return new Irelia();
    }

    /**
     *   *** 
     *       如果是以@Configuration进行加入多个通接口bean进入容器的话，那么注入的时候，属性的名字一定要与‘方法名’一致！！！！！
     *   ***
     */

    //只有两个同类型的bean，一个加入了一个未加入，那么就会以bytype的形式进行处理！！！！！！
}
