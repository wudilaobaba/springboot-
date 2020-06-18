package com.whj.springbootcode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
public class XxDTO {
    private Integer top;
    private Integer bottom;
}
