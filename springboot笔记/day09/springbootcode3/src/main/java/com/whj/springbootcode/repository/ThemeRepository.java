/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-07-18 07:18
 */
package com.whj.springbootcode.repository;

import com.whj.springbootcode.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query("select t from Theme t where t.name in (:names)")
    List<Theme> xxx(
            @Param("names")
            List<String> names
    );

    @Query("select t from Theme t where t.id > (:id) and t.id < (:small)")
    List<Theme> yyy(
            @Param("id")
            Long id,
            @Param("small")
            Long small
    );

    Optional<Theme> findByName(String name);
}
