package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.model.Category;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.service.CategoryService;
import com.whj.springbootcode.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "all",method = {RequestMethod.GET,RequestMethod.POST})
    public CategoriesAllVO getAllCategory(){
        Map<Integer,List<Category>> map = this.categoryService.getCategoryList();
        return new CategoriesAllVO(map);
    }
}
