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
public class Category extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;
    private Long online;
    private Long level;

    @OneToMany//产生一对多的关系，写在"一"的一方
    @JoinColumn(name="categoryId")//指明外键的名字(与外键名字一致)，写在"一"的一方
    private List<Spu> spuList;
}
