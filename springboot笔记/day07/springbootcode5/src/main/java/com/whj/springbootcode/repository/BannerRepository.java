package com.whj.springbootcode.repository;

import com.whj.springbootcode.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner,Long> {
    //                                           操作的实体类型，实体的主键类型
    Banner findOneById(Long id);
    Banner findOneByName(String name);
}
