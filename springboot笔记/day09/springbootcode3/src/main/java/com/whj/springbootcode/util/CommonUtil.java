package com.whj.springbootcode.util;

import com.whj.springbootcode.bo.PageCounter;

public class CommonUtil {
    /**
     * 将移动端的分页start转换为页码
     * @retuen PageCounter对象，包含了 页码 和 每页数量
     */
    public static PageCounter converToPageParameter(Integer start, Integer count){
        //此处将前端传过来的条目起始索引值转换为页码
        int pageNum = start/count;

        PageCounter pageCounter = PageCounter.builder().pageNum(pageNum).count(count).build();
        return pageCounter;
    }
}
