package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.dto.PeosonDTO;
import com.whj.springbootcode.dto.XxDTO;
import com.whj.springbootcode.exception.http.ForbiddenException;
import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Banner;
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

    //真实接口 = = = = =
    @Autowired
    private BannerService bannerServiceImpl;
    @RequestMapping(value="/name/{name}", method={RequestMethod.GET,RequestMethod.POST}) //限制只能用GET和POST方式访问
    public Banner getByName(
            @PathVariable
            @NotBlank(message = "banner名能不能别为空啊！！！！") //非空校验
            String name
    ){
        Banner banner = bannerServiceImpl.getByName(name);
        if(banner == null){
            throw new NotFoundException(30005);
        }
        return banner;
    }

}