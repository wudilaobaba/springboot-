package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.model.Category;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取Category列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Category> getAllCategory(){
        return this.categoryService.getAllCategory();
    }
}
