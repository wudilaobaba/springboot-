package com.whj.springbootcode.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whj.springbootcode.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用来进行JSON字符串与List的互转
 */
@Converter
public class ListAndJson implements AttributeConverter<List<Object>,String> {
    @Autowired
    private ObjectMapper mapper;

    /**
     * 序列化,将单一的Map对象转化为字符串
     * @return
     */
    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        try {
            return mapper.writeValueAsString(objects);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }


    /**
     * 序列化,将List对象转化为字符串
     * @return
     */
    @Override
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if(s == null){
                return null;
            }
            List<Object> t = mapper.readValue(s, List.class);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
