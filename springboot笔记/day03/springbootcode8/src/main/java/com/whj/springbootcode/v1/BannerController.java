package com.whj.springbootcode.v1;

import com.whj.springbootcode.sample.IConnect;
import com.whj.springbootcode.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //该注解中已经有@Component注解了
//@Lazy
@RequestMapping("/v1/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @Autowired
    private IConnect m;



    @RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test(){
        this.m.connect();
        return this.bannerService.testCode()?"Right":"Wrong";
    }
}