package com.whj.springbootcode.dto.validators;


import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenPasswordValidator implements ConstraintValidator<TokenPassword,String> {
    private Integer min;
    private Integer max;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.min = constraintAnnotation.min(); //获取注解中的min
        this.max = constraintAnnotation.max(); //获取注解中的max
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(s)){//说明是小程序登录，所以无需传password字段
            return true;
        }

        //说明是其他方式登录，一定要传password字段
        return s.length()>=this.min && s.length()<=this.max;
    }
}
