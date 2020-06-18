package com.whj.springbootcode.sample.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DinanaCondition implements Condition {
    //自动生成以下方法
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false; //返回true那么应用该类的bean才会加入到容器中
    }
}
