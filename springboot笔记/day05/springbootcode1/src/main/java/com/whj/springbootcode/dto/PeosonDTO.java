package com.whj.springbootcode.dto;

import lombok.*;

@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
@Builder
public class PeosonDTO {
    private String name;
    private Integer age;
}
