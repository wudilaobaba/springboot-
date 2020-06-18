package com.whj.javatestcode.sample.hero;

import com.whj.javatestcode.sample.ISkill;
import org.springframework.stereotype.Component;

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
        System.out.println("Dinana's RRR R");
    }
}
