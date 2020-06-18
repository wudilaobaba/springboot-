package com.whj.springbootcode.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Theme;
import com.whj.springbootcode.service.ThemeService;
import com.whj.springbootcode.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("theme")
@Validated
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    /**
     * 根据多个name来获取theme数据，返回不带有Spu的theme数据
     * @param names
     * @return
     */
    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(
            @RequestParam(name = "names")
            String names
    ) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByNames(nameList);
        List<ThemePureVO> list = themes.stream().map(ThemePureVO::new).collect(Collectors.toList());
        return list;
    }

    /**
     * 测试自定义JPQL用的
     * @param id
     * @param small
     * @return
     */
    @GetMapping("/by/{id}/{small}")
    public List<ThemePureVO> getThemeById(
            @PathVariable
            Long id,
            @PathVariable
            Long small
    ) {
        List<Theme> themes = this.themeService.testFindTheme(id,small);
        List<ThemePureVO> list = themes.stream().map(ThemePureVO::new).collect(Collectors.toList());
        return list;
    }


    /**
     * 根据1个name来获取theme数据，返回不带有Spu的theme数据
     * @param themeName
     * @param start
     * @param count
     * @return
     */
    @GetMapping("/name/{name}/with_spu")
    public Theme getThemeByNameWithSpu(
            @PathVariable(name = "name")
            String themeName,
            @RequestParam
            Integer start,
            @RequestParam
            Integer count
    ){
        Optional<Theme> optionalTheme = this.themeService.findByName(themeName);
        return optionalTheme.orElseThrow(()-> new NotFoundException(30003));
    }
}
