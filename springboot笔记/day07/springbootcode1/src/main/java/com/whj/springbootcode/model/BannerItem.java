package com.whj.springbootcode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class BannerItem {
    @Id
    private Long id;
    private String img;
    private String keyword;
    private short type;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Long bannerId; //外键
    private String name;
}
