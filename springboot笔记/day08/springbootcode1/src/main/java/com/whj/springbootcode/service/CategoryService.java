package com.whj.springbootcode.service;

import com.whj.springbootcode.model.Category;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return this.categoryRepository.findAll();
    }
}
