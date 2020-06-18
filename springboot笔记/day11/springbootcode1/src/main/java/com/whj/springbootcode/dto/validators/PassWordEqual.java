package com.whj.springbootcode.dto.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented //让注解中的注释加入到文档中
@Retention(RetentionPolicy.RUNTIME) //注解保留在什么阶段，此时是运行阶段
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//将注解使用在哪里，这里我们可以使用在类上面 和 方法上面 和 字段上面
@Constraint(validatedBy = PasswordValidator.class) //将自定义注解和关联类关联在一起
public @interface PassWordEqual {
    String message() default "两次密码不相同";
    //message的使用：@PassWordEqual(message="密码错了不好意思")

    int min() default 4;
    //min的使用：@PassWordEqual(min=6)

    int max() default 6;
    //max的使用：@PassWordEqual(max=10)


    //强制要求：只要写自定义校验注解就写以下两行代码：
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
