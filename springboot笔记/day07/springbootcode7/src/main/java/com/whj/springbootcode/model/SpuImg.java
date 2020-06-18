package com.whj.springbootcode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Setter
@Getter
@Entity
public class SpuImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;
}
