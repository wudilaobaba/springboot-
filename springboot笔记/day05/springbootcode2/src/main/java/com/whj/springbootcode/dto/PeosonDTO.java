package com.whj.springbootcode.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;
@NoArgsConstructor //body体参数校验必须要有一个无参构造器
@AllArgsConstructor
@Builder
@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
public class PeosonDTO {
    @Length(min = 1,max = 10,message = "别超过1~10")
    private String name;
    @Max(100)
    private Integer age;


    //对象中校验对象
    @Valid //想要校验对象中的对象中的字段，就要打上@Valid注解
    private SchoolDTO schoolDTO;

}
