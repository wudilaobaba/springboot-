package com.whj.springbootcode.model1;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theme {
    @Id
    private Long id;
    private String title;
    private String name;


    //导航属性
    @ManyToMany
    @JoinTable(
            name="theme_spu", // name:指定第三张表的表名
            joinColumns = @JoinColumn(name="theme_id"),// joinColumns指定第三张表中的一个外键
            inverseJoinColumns = @JoinColumn(name="spu_id")// inverseJoinColumns 指定第三张表中的另一个外键
    )
    private List<Spu> spuList;
}
