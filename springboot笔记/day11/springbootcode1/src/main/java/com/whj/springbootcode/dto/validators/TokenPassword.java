package com.whj.springbootcode.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented //让注解中的注释加入到文档中
@Retention(RetentionPolicy.RUNTIME) //注解保留在什么阶段，此时是运行阶段
@Target({ElementType.FIELD})//将注解使用在哪里，这里我们可以字段上面
@Constraint(validatedBy = TokenPasswordValidator.class) //将自定义注解和关联类关联在一起
public @interface TokenPassword {
    String message() default "字段不符合要求";
    //message的使用：@TokenPassword(message="密码错了不好意思")

    int min() default 6;
    //min的使用：@TokenPassword(min=6)

    int max() default 32;
    //max的使用：@TokenPassword(max=10)


    //强制要求：只要写自定义校验注解就写以下两行代码：
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
