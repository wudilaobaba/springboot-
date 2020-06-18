package com.whj.springbootcode.sample.hero;

import com.whj.springbootcode.sample.ISkill;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class Irelia implements ISkill {
    /**
     * 测试立即实例化
     */
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
