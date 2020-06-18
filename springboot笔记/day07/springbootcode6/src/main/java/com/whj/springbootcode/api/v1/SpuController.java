package com.whj.springbootcode.api.v1;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.whj.springbootcode.bo.PageCounter;
import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.service.SpuService;
import com.whj.springbootcode.util.CommonUtil;
import com.whj.springbootcode.vo.Paging;
import com.whj.springbootcode.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
            @NotNull(message = "id能不能别为空啊！！！！")
            Long id
    ){
        Spu spu = this.spuService.getSpuDetail(id);
        if(spu == null){
            throw new NotFoundException(30003);
        }
        return spu;
    }

    /**
     * 将spu列表以vo对象的字段形式返回
     * @return
     */
    @RequestMapping(value="/latest", method={RequestMethod.GET,RequestMethod.POST})
    public List<SpuSimplifyVO> getLatestSpuList(
            //前端传start为从哪条数据开始
            @RequestParam(defaultValue = "0") //问号传参使用@RequestParam注解, 前端不传回传默认值
            Integer start,
            @RequestParam(defaultValue = "10") //问号传参使用@RequestParam注解,前端不传回传默认值
            Integer count
    ){
        //将start转换为页码
        PageCounter pageCounter = CommonUtil.converToPageParameter(start,count);

        //数据库查询到的原始数据,getLatestPagingSpu中的参数是页码
        Page<Spu> spuList = this.spuService.getLatestPagingSpu(pageCounter.getPageNum(),pageCounter.getCount());

        //定义转换为vo的对象，固定写法
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<SpuSimplifyVO> vos = new ArrayList<>();

        //循环遍历转换vo并追加到vos中
        spuList.forEach(s->{//s就是每一个spu
            SpuSimplifyVO vo = mapper.map(s,SpuSimplifyVO.class);//第二个参数是目标对象的原类
            vos.add(vo);
        });

        return vos;
    }



    /**
     * 获取一个SpuSimplifyVO，测试
     * @return
     */
    @RequestMapping(value="/id/{id}/simplify", method={RequestMethod.GET,RequestMethod.POST})
    public SpuSimplifyVO getSimplifySpu(
            @PathVariable
            @NotNull(message = "id能不能别为空啊！！！！")
            Long id
    ){
        SpuSimplifyVO vo = new SpuSimplifyVO();
        Spu spu = this.spuService.getSpuDetail(id);
        if(spu == null){
            throw new NotFoundException(30003);
        }
        BeanUtils.copyProperties(spu,vo);
        return vo;
    }

}
