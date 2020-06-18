package com.whj.springbootcode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Theme extends BaseEntity{
    @Id
    private Long id;
    private String title;
    private String description;
    private String name;
    private String extend;
    private String entranceImg;
    private String internalTopImg;
    private Boolean online;
    private String titleImg;
    private String tplName;

    @ManyToMany
    @JoinTable(
            name="theme_spu", // name:指定第三张表的表名
            joinColumns = @JoinColumn(name="theme_id"),// joinColumns指定第三张表中的一个外键
            inverseJoinColumns = @JoinColumn(name="spu_id")// inverseJoinColumns 指定第三张表中的另一个外键
    )
    private List<Spu> spuList;
}
