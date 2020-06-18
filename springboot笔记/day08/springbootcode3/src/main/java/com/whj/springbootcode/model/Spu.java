package com.whj.springbootcode.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.whj.springbootcode.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity{
    @Id
    private Long id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Long rootCategoryId;
    private Boolean online;
    private String price;
    private Long sketchSpecId;
    private Long defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Boolean isTest;

    @Convert(converter = MapAndJson.class)
    private Map<String,Object> spuThemeImg;//是一个JSON格式, 报错不管他

    private String forThemeImg;

    @OneToMany
    @JoinColumn(name="spuId")
    private List<Sku> skuList;

    @OneToMany
    @JoinColumn(name="spuId")
    private List<SpuImg> spuImgList;

    @OneToMany
    @JoinColumn(name="spuId")
    private List<SpuDetailImg> spuDetailImgList;
}
