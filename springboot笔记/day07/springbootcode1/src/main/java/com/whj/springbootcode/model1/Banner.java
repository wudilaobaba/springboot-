package com.whj.springbootcode.model1;

import javax.persistence.*;
import java.util.List;

//jpa注解
@Entity
@Table(name="banner") //自定义数据库中的表名
public class Banner {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置组件自增
    private long id;

    @Column(length = 10) //限制name的字符长度
    private String name;

    @Transient //数据表中不会存在discription字段
    private String discription;

    private String img;
    private String title;




    //双向一对多 规则01
    @OneToMany(mappedBy = "banner")//产生一对多的关系，写在"一"的一方   一对多，关系的被维护端在"一"方
//    @org.hibernate.annotations.ForeignKey(name="null") 禁止生成物理外键，不推荐！！！
    private List<BannerItem> items;




}
