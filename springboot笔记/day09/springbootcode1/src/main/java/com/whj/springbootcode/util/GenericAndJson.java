package com.whj.springbootcode.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whj.springbootcode.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class GenericAndJson {

    private static ObjectMapper mapper;

    @Autowired //使用setter的方式注入
    public void setMapper(ObjectMapper mapper){
        GenericAndJson.mapper = mapper; //静态属性注入
    }

    /**
     * 序列化: 写入数据库用的
     *  将单一的Map对象 转化为字符串
     *  将List对象     转化为字符串
     * @param o
     * @return
     */
    public static<T> String ObjectToJson(T o){
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }



    //=========  给前端看的 ====  给前端看的 =======  给前端看的  =========


    /**
     * 反序列化
     *  String转Map 给前端看的
     *  String转List 给前端看的
     * @param
     * @return
     */
    public static<T> T josnToObject(String s, TypeReference<T> tr){
        if(s == null){
            return null;
        }
        try {
            return GenericAndJson.mapper.readValue(s, tr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
