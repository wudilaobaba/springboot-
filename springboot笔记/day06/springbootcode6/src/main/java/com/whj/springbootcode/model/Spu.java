package com.whj.springbootcode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Spu {
    @Id
    private Long id;
    private String title;
    private String subtitle;


    //导航属性
    @ManyToMany(mappedBy = "spuList")//关系的被维护方要加上mappedBy属性  多对多，关系的被维护端不一定在哪一端
    private List<Theme> themeList;
}
