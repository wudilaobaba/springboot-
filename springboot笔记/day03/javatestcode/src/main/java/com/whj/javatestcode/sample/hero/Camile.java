package com.whj.javatestcode.sample.hero;

import com.whj.javatestcode.sample.ISkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Camile implements ISkill {
    @Autowired
    private ISkill ix; //如果Configuration中有两个接口的bean,那么该类中忽略掉自己的bean，默认为只有一个bean

    public void q(){
        System.out.println("Camile's Q");
    }
    public void w(){
        System.out.println("Camile's W");
    }
    public void e(){
        System.out.println("Camile's E");
    }
    public void r(){
        this.ix.r();
    }
}
