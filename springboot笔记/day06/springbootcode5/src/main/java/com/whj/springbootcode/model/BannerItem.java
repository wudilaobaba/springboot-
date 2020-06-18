package com.whj.springbootcode.model;

import javax.persistence.*;

@Entity
@Table(name="items")
public class BannerItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置组件自增
    private Long id;
    private String img;
    private String keyword;
    private Short type;
    private String name;

    //一对多的外键，写在"多"的一方，然后在"一"的一方进行注解标明
    private Long bannerId;
}
