package com.whj.javatestcode.api.v1;

import com.whj.javatestcode.sample.ISkill;
import com.whj.javatestcode.sample.hero.Camile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Autowired
    private ISkill c;

    @RequestMapping("/test01")
    public String test01(){
        this.c.r();
        return "test";
    }
}
