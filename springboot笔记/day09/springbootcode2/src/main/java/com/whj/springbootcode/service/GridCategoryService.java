package com.whj.springbootcode.service;

import com.whj.springbootcode.model.GridCategory;
import com.whj.springbootcode.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    public List<GridCategory> getGridCategoryList(){
        return this.gridCategoryRepository.findAll();
    }
}
