package com.whj.springbootcode.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    //列表总数量
    private Long total;

    //请求到了多少条
    private Integer count;

    //当前页码
    private Integer page;

    //总页码
    private Integer totalPage;

    private List<T> items;

    public Paging(Page<T> pageT){
        //因为在controller中定义了从数据库中查询出来的数据都是Page类型，那么
        //所有的数据都在pageT中，所以以上属性的值都可以从pageT中获得
        this.initPageParameters(pageT);
        this.items = pageT.getContent();//数据库中的真实查询出的数据
    }

    /**
     * 初始化以上属性的值
     */
    private void initPageParameters(Page<T> pageT){
        this.total = pageT.getTotalElements();
        this.count = pageT.getSize();
        this.page = pageT.getNumber();
        this.totalPage = pageT.getTotalPages();
    }
}
