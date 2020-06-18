package com.whj.springbootcode.sample.hero;

import com.whj.springbootcode.sample.ISkill;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Camille implements ISkill {

    public void q(){
        System.out.println("Camille's Q");
    }
    public void w(){
        System.out.println("Camille's W");
    }
    public void e(){
        System.out.println("Camille's E");
    }
    public void r(){
        System.out.println("Camille's R");
    }
}
