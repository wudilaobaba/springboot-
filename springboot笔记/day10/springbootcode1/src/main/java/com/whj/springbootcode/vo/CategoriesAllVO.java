package com.whj.springbootcode.vo;

import com.whj.springbootcode.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriesAllVO {
    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;
    public CategoriesAllVO(Map<Integer,List<Category>> map){
        //先处理原始数据中的每一个元素转为VO，再将所有VO放进List中
        this.roots = map.get(1).stream().map(r->{//r是List中的每一个元素
            return new CategoryPureVO(r);//将每一个Category转为CategoryPureVO
        }).collect(Collectors.toList());//在以List的形式返回

        //上下两种的写法不同，但结果相同

        this.subs = map.get(2).stream().map(CategoryPureVO::new).collect(Collectors.toList());//在以List的形式返回
    }
}
