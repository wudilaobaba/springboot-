package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.dto.PeosonDTO;
import com.whj.springbootcode.dto.XxDTO;
import com.whj.springbootcode.exception.http.ForbiddenException;
import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.service.BannerService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;


@RestController //该注解中已经有@Component注解了
@RequestMapping("/banner")
@Validated
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


    //测试前端接收对象
    @RequestMapping(value="/test4", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public XxDTO test4() {
        XxDTO xxDTO = new XxDTO(11,22);
        return xxDTO; //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
    }


    //测试前端传参 ===
    @RequestMapping(value="/test5/{id1}", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public PeosonDTO test5(

            @PathVariable(name="id1") //接收路由中斜线后面的参数
            @Max(value = 20,message = "别超过20可以吗") //路由中斜线后面的参数值不能大于20
            @Range(min=1,max = 10,message = "必须1~10")//路由中斜线后面的参数值不能超过1~10
            Integer id,

            @RequestParam   //接收路由中问号后面的参数
            @Length(min = 2,max = 6,message = "name必须2~6")
            String name,


//            第一种接收body体参数的方式
//            @RequestBody Map<String,Object> person


//            第二种接收body体参数的方式 : 注意：实体类一定要有一个无参的构造函数
            @RequestBody(required = false)//(required = false) 允许body体为空
            @Validated //需要进行body体中参数校验就加上该注解,校验规则写在PeosonDTO类中
            PeosonDTO peosonDTO //接收body体中的参数


    ) {

        PeosonDTO peosonDTO1 = PeosonDTO.builder().age(12).name("xxxxxx").build();
        return peosonDTO;
    }





    //真实接口 = = = = =
    @Autowired
    private BannerService bannerServiceImpl;
    @RequestMapping(value="/name/{name}", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public Banner getByName(
            @PathVariable
            @NotBlank(message = "姓名能不能别为空啊！！！！") //非空校验
            String name
    ){
        Banner banner = bannerServiceImpl.getByName(name);
        return banner;
    }

}