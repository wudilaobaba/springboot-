package com.whj.springbootcode.model1;

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





    //双向一对多 规则02
    private Long bannerId;
    @ManyToOne//产生多对一的关系，写在"多"的一方
    @JoinColumn(insertable = false, updatable = false, name="bannerId")//指明外键的名字(与外键名字一致)，写在"多"的一方
    private Banner banner;
}
