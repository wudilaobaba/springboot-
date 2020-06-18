package com.whj.springbootcode.sample.hero;

import com.whj.springbootcode.sample.ISkill;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Dinana implements ISkill {
    public void q(){
        System.out.println("Dinana's Q");
    }
    public void w(){
        System.out.println("Dinana's W");
    }
    public void e(){
        System.out.println("Dinana's E");
    }
    public void r(){
        System.out.println("Dinana's R");
    }
}
