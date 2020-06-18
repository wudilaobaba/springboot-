package com.whj.springbootcode.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.whj.springbootcode.util.GenericAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    private String spuThemeImg;//是一个JSON格式
    public Map<String,Object> getSpuThemeImg(){
        return GenericAndJson.josnToObject(this.spuThemeImg, new TypeReference<Map<String, Object>>() {});
    }
    public void setSpuThemeImg(Map<String,Object> spuThemeImg){
        this.spuThemeImg = GenericAndJson.ObjectToJson(spuThemeImg);
    }

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


    @ManyToMany(mappedBy = "spuList")//关系的被维护方要加上mappedBy属性  多对多，关系的被维护端不一定在哪一端
    private List<Theme> themeList;
}
