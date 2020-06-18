package com.whj.springbootcode.sample;

import com.whj.springbootcode.sample.database.IConnect;
import com.whj.springbootcode.sample.database.MySql;
import com.whj.springbootcode.sample.hero.Camille;
import com.whj.springbootcode.sample.hero.Dinana;
import com.whj.springbootcode.sample.hero.Irelia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

    @Bean //方法上加@Bean就一定要返回一个bean
    public ISkill camille(){ //***注入的时候bean的名字就是该方法名，方法名可以修改！！！！！！！！！！！！！
        Camille camille = new Camille();
        camille.setAge(12);
        camille.setName("www");
        return camille;
    }

    @Bean
    public ISkill irelia(){  //***注入的时候bean的名字就是该方法名，方法名可以修改！！！！！！！！！！！！！
        return new Irelia();
    }
}
