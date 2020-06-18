package com.whj.javatestcode.sample;

import com.whj.javatestcode.sample.hero.Camile;
import com.whj.javatestcode.sample.hero.Dinana;
import com.whj.javatestcode.sample.hero.Irelia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Bean
    public ISkill c(){
        return new Camile();
    }

    @Bean
    public ISkill d(){
        return new Dinana();
    }
}
