package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.dto.PeosonDTO;
import com.whj.springbootcode.exception.http.ForbiddenException;
import com.whj.springbootcode.exception.http.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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


    //测试前端传参 ===
    @RequestMapping(value="/test4/{id1}", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public String test4(

            @PathVariable(name="id1") //接收路由中斜线后面的参数
            Integer id,

            @RequestParam   //接收路由中问号后面的参数
            String name

            @RequestBody Map<String,Object> person //接收body体中的参数，body体中随便传json,在下方都会打印出来


    ) {
        System.out.println(person);
        System.out.println(id);
        System.out.println(name);
        PeosonDTO peosonDTO = PeosonDTO.builder().name("whj").age(12).build();//
        throw new ForbiddenException(0);
    }
}
