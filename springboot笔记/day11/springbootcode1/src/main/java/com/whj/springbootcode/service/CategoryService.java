package com.whj.springbootcode.service;

import com.whj.springbootcode.model.Category;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Map<Integer,List<Category>> getCategoryList(){
        List<Category> roots = this.categoryRepository.findCategoryByIsRootOrderByIndexAsc(true);
        List<Category> subs = this.categoryRepository.findCategoryByIsRootOrderByIndexAsc(false);
        Map<Integer,List<Category>> categories = new HashMap<>();
        categories.put(1,roots);
        categories.put(2,subs);
        return categories;
    }
}
