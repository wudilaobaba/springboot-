package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController //该注解中已经有@Component注解了
@RequestMapping("/spu")
@Validated
public class SpuController {
    @Autowired
    private SpuService spuService;
    @RequestMapping(value="/id/{id}/detail", method={RequestMethod.GET,RequestMethod.POST})
    public Spu getDetail(
            @PathVariable
            @NotNull(message = "banner名能不能别为空啊！！！！")
            Long id
    ){
        Spu spu = this.spuService.getSpuDetail(id);
        if(spu == null){
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @RequestMapping(value="/latest", method={RequestMethod.GET,RequestMethod.POST})
    public List<Spu> getLatestSpuList(){
        return this.spuService.getLatestPagingSpu();
    }

}
