package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.bo.PageCounter;
import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.service.SpuService;
import com.whj.springbootcode.util.CommonUtil;
import com.whj.springbootcode.vo.PagingDozer;
import com.whj.springbootcode.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.websocket.server.PathParam;
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
    public PagingDozer<Spu,SpuSimplifyVO> getLatestSpuList(
            //前端传start为从哪条数据开始
            @RequestParam(defaultValue = "0") //问号传参使用@RequestParam注解, 前端不传回传默认值
            Integer start,
            @RequestParam(defaultValue = "10") //问号传参使用@RequestParam注解,前端不传回传默认值
            Integer count
    ){
        //将start转换为页码
        PageCounter pageCounter = CommonUtil.converToPageParameter(start,count);

        //数据库查询到的原始数据列表,getLatestPagingSpu中的参数是页码
        Page<Spu> page = this.spuService.getLatestPagingSpu(pageCounter.getPageNum(),pageCounter.getCount());

        //使用PagingDozer的构造函数返回pagingDozer
        return new PagingDozer<>(page, SpuSimplifyVO.class);
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


    /**
     * 根据category_id获取对应的spu列表
     * @return
     */
    @RequestMapping(value="/by/category/{category_id}", method={RequestMethod.GET,RequestMethod.POST})
    public PagingDozer<Spu,SpuSimplifyVO> getByCatgoryId(
            @PathVariable(name="category_id")
            Long categoryId,
            @RequestParam(name = "is_root",defaultValue = "false") //默认值都是字符串
            Boolean isRoot,
            @RequestParam(defaultValue = "0")
            Integer start,
            @RequestParam(defaultValue = "10")
            Integer count
    ){
        Page<Spu> page = this.spuService.getSpuByCategoryId(categoryId,isRoot,start,count);
        return new PagingDozer<>(page, SpuSimplifyVO.class);
    }
}
