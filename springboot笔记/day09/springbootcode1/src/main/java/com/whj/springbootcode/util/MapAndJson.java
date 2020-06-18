package com.whj.springbootcode.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whj.springbootcode.exception.http.ServerErrorException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来进行JSON字符串与Map单体的互转
 */
@Converter
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {
    //                               该字段想要转换成的模型中的类型，数据库中的该字段的类型(josn就用String表示)
    @Autowired
    private ObjectMapper mapper;

    /**
     * 序列化,将单一的Map对象转化为字符串
     * @param stringObjectMap
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }



    /**
     * 反序列化，Map转String
     * @param
     * @return
     */
    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            if(s == null){
                return null;
            }
            return mapper.readValue(s, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
