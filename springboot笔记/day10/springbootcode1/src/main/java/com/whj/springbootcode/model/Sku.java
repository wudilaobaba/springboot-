package com.whj.springbootcode.model;


import com.fasterxml.jackson.core.type.TypeReference;
import com.whj.springbootcode.util.GenericAndJson;
import com.whj.springbootcode.util.ListAndJson;
import com.whj.springbootcode.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collections;
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
     * 通过specs的get/set方法来进行序列化与反序列化的实现！！！
     */
    private String specs; //数据库中的specs是JSON类型，这里要改为String
    public List<Spec> getSpecs() {
        if(this.specs == null){
            return Collections.emptyList();//返回空List的方法
        }
        return GenericAndJson.josnToObject(this.specs, new TypeReference<List<Spec>>() {});
    }

    public void setSpecs(List<Spec> specs) {
        if(specs.isEmpty()){
            return;
        }
        this.specs = GenericAndJson.ObjectToJson(specs);
    }




//    数据库的单体JSON字段返回Map
//    @Convert(converter = MapAndJson.class)
//    private Map<String,Object> test; //报错不管他
    private String test;
    public Map<String,Object> getTest(){
        return GenericAndJson.josnToObject(this.test, new TypeReference<Map<String, Object>>() {});
    }
    public void setTest(Map<String,Object> test){
        this.test = GenericAndJson.ObjectToJson(test);
    }

    private String code; //sku唯一标识
    private Long stock; //库存量


}
