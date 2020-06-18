package com.whj.springbootcode.service;

import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;
    public Spu getSpuDetail(Long id){
        return this.spuRepository.findOneById(id);
    }

    public List<Spu> getLatestPagingSpu(){
        return this.spuRepository.findAll();
    }
}
