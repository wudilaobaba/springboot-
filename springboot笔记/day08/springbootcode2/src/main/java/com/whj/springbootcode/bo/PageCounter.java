package com.whj.springbootcode.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageCounter {
    //页码
    private Integer pageNum;
    //每页数量
    private Integer count;
}
