package com.whj.springbootcode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;

    //这里配置单项一对多
    @OneToMany//产生一对多的关系，写在"一"的一方   一对多，关系的被维护端在"一"方
    @JoinColumn(name="bannerId")
    private List<BannerItem> items;
}
