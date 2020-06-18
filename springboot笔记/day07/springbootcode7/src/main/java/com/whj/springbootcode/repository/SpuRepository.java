package com.whj.springbootcode.repository;

import com.whj.springbootcode.model.Banner;
import com.whj.springbootcode.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);
}
