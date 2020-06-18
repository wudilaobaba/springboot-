package com.whj.springbootcode.core.configuration;

import com.whj.springbootcode.core.hack.AutoPreFixUrlMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
@Component
public class AutoPrefixUrlConfiguraton implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new AutoPreFixUrlMapping();
    }
}
