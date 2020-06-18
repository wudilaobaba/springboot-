package com.whj.springbootcode.model;

import com.whj.springbootcode.util.ListAndJson;
import com.whj.springbootcode.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
public class Sku extends BaseEntity{
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    private Long categoryId;
    private Long rootCategoryId;


    /**
     * 该字段在写入的时候要将List类型转为JSON
     * 该字段在读取的时候要将JSON转为List
     */
    @Convert(converter = ListAndJson.class)
    private List<Spec> specs; //数据库中的specs是JSON类型，无法与List进行对应




//    数据库的单体JSON字段返回Map
    @Convert(converter = MapAndJson.class)
    private Map<String,Object> test; //报错不管他

    private String code; //sku唯一标识
    private Long stock; //库存量


}
