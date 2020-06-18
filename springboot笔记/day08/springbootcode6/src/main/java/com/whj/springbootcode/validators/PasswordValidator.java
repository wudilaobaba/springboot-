package com.whj.springbootcode.validators;


import com.whj.springbootcode.dto.PeosonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PassWordEqual,PeosonDTO> {
    //第一个泛型: 是自定义注解的类型
    //第二个泛型: 传入自定义注解修饰的目标的类型，就是自定义注解打在类上，还是方法上，还是字段上，是什么上，该泛型就是什么类型

    private int min;
    private int max;
    /**
     * 获取注解中的参数信息
     * @param constraintAnnotation
     */
    @Override
    public void initialize(PassWordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min(); //获取注解中的min
        this.max = constraintAnnotation.max(); //获取注解中的max
    }


    /**
     * 获取实体的信息
     * @param peosonDTO
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(PeosonDTO peosonDTO, ConstraintValidatorContext constraintValidatorContext) {
        //具体的校验逻辑写在这里：校验通过返回true   否则返回false
        //获取peosonDTO中password1和password2

        String password1 = peosonDTO.getPassword1();
        String password2 = peosonDTO.getPassword2();
        boolean isPswSame = password1.equals(password2);//两次密码是否相同
        if(isPswSame){
            boolean isPswLenRight = password1.length()>=this.min && password1.length()<=this.max;
            if(isPswLenRight){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }



}
