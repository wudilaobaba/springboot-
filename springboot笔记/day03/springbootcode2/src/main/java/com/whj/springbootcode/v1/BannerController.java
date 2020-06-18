package com.whj.springbootcode.v1;

import com.whj.springbootcode.sample.ISkill;
import com.whj.springbootcode.sample.hero.Dinana;
import com.whj.springbootcode.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //该注解中已经有@Component注解了
//@Lazy
@RequestMapping("/v1/banner")
public class BannerController {

    //属性注入(最方便)

    @Autowired
    @Qualifier("irelia")
    private ISkill dinana; //依赖倒置

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test(){
        this.dinana.e();
        return this.bannerService.testCode()?"Right":"Wrong";
    }
}