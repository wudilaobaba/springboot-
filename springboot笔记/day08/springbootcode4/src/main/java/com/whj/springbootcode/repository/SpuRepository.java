package com.whj.springbootcode.repository;

import com.whj.springbootcode.model.Banner;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.vo.PagingDozer;
import com.whj.springbootcode.vo.SpuSimplifyVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);

    /**
     * spu中根据category_id获取spu列表
     * @return
     */
    Page<Spu> findByCategoryId(Long id,Pageable page);

    /**
     * spu中根据根id获取spu列表
     * @param id
     * @param page
     * @return
     */
    Page<Spu> findByRootCategoryId(Long id,Pageable page);
}
