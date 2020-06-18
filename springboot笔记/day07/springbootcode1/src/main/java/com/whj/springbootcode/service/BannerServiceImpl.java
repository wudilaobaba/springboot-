package com.whj.springbootcode.service;

import com.whj.springbootcode.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerRepository bannerRepository;

    public Banner getByName(String name){
        //根据name进行查询数据库
        return bannerRepository.findOneByName(name);
    }
}
