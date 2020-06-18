package com.whj.springbootcode.service;

import com.whj.springbootcode.bo.PageCounter;
import com.whj.springbootcode.model.Spu;
import com.whj.springbootcode.repository.SpuRepository;
import com.whj.springbootcode.util.CommonUtil;
import com.whj.springbootcode.vo.PagingDozer;
import com.whj.springbootcode.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;
    public Spu getSpuDetail(Long id){
        return this.spuRepository.findOneById(id);
    }

    public Page<Spu> getLatestPagingSpu(Integer pageNum,Integer size){//此处参数为传统分页传参
        //传参是那种传统的pc端传参方式(页码，每页数量)，但是移动端要把当前条目序号转换为页码,作为第一个参数
        //descending倒序 Sort.by("字段名驼峰形式") - 根据某个字段进行排序
        Pageable page = PageRequest.of(pageNum,size, Sort.by("createTime").descending());

        //将Pageable对象到findAll方法中,会返回一个Page对象
        Page<Spu> pageSup = this.spuRepository.findAll(page);
        return pageSup;
    }

    public Page<Spu> getSpuByCategoryId(Long id,boolean isRoot, int start,int count){
        PageCounter pageCounter = CommonUtil.converToPageParameter(start,count);
        Pageable page = PageRequest.of(pageCounter.getPageNum(),pageCounter.getCount());
        if(isRoot){
            return this.spuRepository.findByRootCategoryId(id, page);
        }
        return this.spuRepository.findByCategoryId(id, page);
    }
}
