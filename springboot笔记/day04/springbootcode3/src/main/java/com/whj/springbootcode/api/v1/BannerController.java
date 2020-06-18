package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.exception.http.ForbiddenException;
import com.whj.springbootcode.exception.http.NotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //该注解中已经有@Component注解了
@RequestMapping("/banner")
public class BannerController {

    @RequestMapping(value="/test1", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test1() throws Exception {
        throw new Exception("45456456");
    }

    @RequestMapping(value="/test2", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test2() {
        throw new NotFoundException(10001);
    }

    @RequestMapping(value="/test3", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test3() {
        throw new ForbiddenException(0);
    }
}