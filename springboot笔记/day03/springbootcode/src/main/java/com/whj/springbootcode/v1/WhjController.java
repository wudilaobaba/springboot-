package com.whj.springbootcode.v1;

import com.whj.springbootcode.sample.hero.Dinana;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/whj")
public class WhjController {
    private Dinana dinana;

    //构造注入(最推荐)

    public WhjController(Dinana dinana){
        this.dinana =dinana;
    }
    @RequestMapping(value = "/test01",method = {RequestMethod.GET,RequestMethod.POST})
    public String test01(){
        this.dinana.w();
        return "123456";
    }
}
