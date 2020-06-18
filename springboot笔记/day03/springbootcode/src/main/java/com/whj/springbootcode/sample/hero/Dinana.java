package com.whj.springbootcode.sample.hero;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Dinana {
    /**
     * 测试立即实例化
     */
    public Dinana(){
        System.out.println("项目一启动，在容器中实例化bean");
    }
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
