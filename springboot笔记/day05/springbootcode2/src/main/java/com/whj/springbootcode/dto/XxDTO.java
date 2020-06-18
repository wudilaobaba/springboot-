package com.whj.springbootcode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //body体参数校验必须要有一个无参构造器
@AllArgsConstructor
@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
public class XxDTO {
    private Integer top;
    private Integer bottom;
}
