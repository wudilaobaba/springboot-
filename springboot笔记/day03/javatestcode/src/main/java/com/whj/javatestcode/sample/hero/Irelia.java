package com.whj.javatestcode.sample.hero;

import com.whj.javatestcode.sample.ISkill;
import org.springframework.stereotype.Component;

public class Irelia implements ISkill {
    public void q(){
        System.out.println("Irelia's Q");
    }
    public void w(){
        System.out.println("Irelia's W");
    }
    public void e(){
        System.out.println("Irelia's E");
    }
    public void r(){
        System.out.println("Irelia's R");
    }
}
