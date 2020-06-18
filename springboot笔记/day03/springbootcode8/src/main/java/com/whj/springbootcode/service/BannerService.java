package com.whj.springbootcode.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    public Boolean testCode(){
        return 1+1 == 9;
    }
}
