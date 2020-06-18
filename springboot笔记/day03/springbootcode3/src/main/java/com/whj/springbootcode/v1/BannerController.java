package com.whj.springbootcode.v1;

import com.whj.springbootcode.sample.ISkill;
import com.whj.springbootcode.sample.database.IConnect;
import com.whj.springbootcode.sample.database.MySql;
import com.whj.springbootcode.sample.hero.Camille;
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
    @Autowired
    private BannerService bannerService;







    //将自定义加入到容器中的bean注入到代码片段中：
    @Autowired
    private ISkill camille; //依赖倒置

    @Autowired
    private ISkill irelia; //依赖倒置

    @Autowired
    private IConnect iConnect; //依赖倒置



    @RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test(){
        Camille camille = (Camille)this.camille;
        System.out.println(camille.getAge());
        System.out.println(camille.getName());

        this.iConnect.connect();


        this.irelia.e();
        return this.bannerService.testCode()?"Right":"Wrong";
    }
}