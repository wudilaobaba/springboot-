package com.whj.springbootcode.core.hack;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 用于处理controller的路由前缀，使得一切接口路径与项目路径保持一致
 */
public class AutoPreFixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${whj.api-package}")
    private String apiPackagePath; //com.whj.springbootcode.api  //controller的根包目录

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if(requestMappingInfo != null){
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix).build().combine(requestMappingInfo);
        }
        return requestMappingInfo;
    }

    private String getPrefix(Class<?> handlerType){
        //获取controller所在的包名:com.whj.springbootcode.api.v1
        String packageName = handlerType.getPackage().getName();

        String dotPath = packageName.replaceAll(this.apiPackagePath,"").replace('.','/');
        return dotPath; //   /v1
    }
}
