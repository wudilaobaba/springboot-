package com.whj.springbootcode.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//jpa注解
@Entity
public class Banner {
    @Id //主键
    private long id;
    private String name;
    private String discription;
    private String img;
    private String title;
}
