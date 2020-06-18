package com.whj.springbootcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass //该注解使得以下三个时间的值都有值了
public abstract class BaseEntity {
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Date deleteTime;
}
