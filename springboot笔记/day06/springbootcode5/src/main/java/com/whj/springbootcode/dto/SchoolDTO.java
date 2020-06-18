package com.whj.springbootcode.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor //body体参数校验必须要有一个无参构造器,以及他需要进行校验的其他对象类中也必须有一个无参构造器
@AllArgsConstructor
@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
public class SchoolDTO {
    @Min(value = 2,message = "至少大于1")
    private Integer schoolName;
}
