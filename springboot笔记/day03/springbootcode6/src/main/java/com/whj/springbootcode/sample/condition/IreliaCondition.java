package com.whj.springbootcode.sample.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IreliaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String name = conditionContext.getEnvironment().getProperty("hero.condition");//获取配置项中的属性值
        return "irelia".equalsIgnoreCase(name); //返回true那么应用该类的bean才会加入到容器中
    }
}
