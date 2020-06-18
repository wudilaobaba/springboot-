package com.whj.springbootcode.repository;

import com.whj.springbootcode.model.Banner;
import com.whj.springbootcode.model.Category;
import com.whj.springbootcode.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    //根据是否是根节点进行查询Category
    List<Category> findCategoryByIsRootOrderByIndexAsc(Boolean isRoot);
}
