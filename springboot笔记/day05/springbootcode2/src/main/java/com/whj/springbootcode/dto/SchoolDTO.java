package com.whj.springbootcode.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter //重点！！！！返回前端的对象中，必须必须必须要有get方法！！！！！！！！
public class SchoolDTO {
    @Length(min=2,message = "最小是2")
    private String schoolName;
}
