package com.whj.springbootcode.service;

import com.whj.springbootcode.exception.http.NotFoundException;
import com.whj.springbootcode.model.Theme;
import com.whj.springbootcode.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> findByNames(List<String> list){
        List<Theme> themeList = this.themeRepository.xxx(list);
        if(themeList.isEmpty()){
            throw new NotFoundException(40001);
        }
        return themeList;
    }

    public List<Theme> testFindTheme(Long id,Long small){
        List<Theme> themeList = this.themeRepository.yyy(id,small);
        if(themeList.isEmpty()){
            throw new NotFoundException(40001);
        }
        return themeList;
    }




    public Optional<Theme> findByName(String name){
        return null;
    }
}
