package com.whjpro.shopserver.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test(){
        return "xxx秘诀911";
    }
}
