package com.whj.springbootcode.dto;

import com.whj.springbootcode.core.enumeration.LoginType;
import com.whj.springbootcode.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
/**
 * 接收前端传来的用户数据
 */
public class TokenGetDTO {
    @NotBlank(message = "account不能为空")
    private String account;

    @TokenPassword(min=6,max=30,message="{token.password}")
    private String password;

    /**
     * 登录类型 ：
     * 1.邮箱登录：account邮箱  password密码
     * 2.手机号登录：account手机号  password验证码、
     * 3.微信小程序登录：account code码  password不需要
     */

    private LoginType type;  //LoginType是枚举类型
}
