package com.whj.springbootcode.v1;

import com.whj.springbootcode.sample.hero.Dinana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/setter")
public class SetterIn {
    //Setter注入：

    private Dinana dinana;

    @Autowired
    public void setDinana(Dinana dinana) {
        this.dinana = dinana;
    }

    @RequestMapping("/test01")
    public String test01(){
        this.dinana.r();
        return "456789";
    }
}
