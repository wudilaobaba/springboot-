package com.whj.springbootcode.core;

import com.whj.springbootcode.core.configuration.ExceptionCodeConfiguration;
import com.whj.springbootcode.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpRetryException;

/**
 *
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    //===========================.未.知.异.常.==============================

    @ExceptionHandler(value=Exception.class) //处理通用异常 - 未知异常
    @ResponseBody //该注解使得controller在抛出异常后，可接受到以下函数返回的值

    /**
     * 返回http的状态码：
     *  HttpStatus.BAD_REQUEST   400
     *  HttpStatus.INTERNAL_SERVER_ERROR  500
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) //500 手动设置http状态码
    public UnifyResponse handleException(HttpServletRequest req, Exception e){
        //一旦controller中抛出了异常，那么程序都会进入到这里
        //参数e就是获取到的错误信息
        //断点可以看到e的异常信息
        System.out.println(e); //后端自己看异常信息
        String requestUrl = req.getRequestURI();//接口地址
        String method = req.getMethod(); //请求方式
        UnifyResponse unifyResponse = new UnifyResponse(9999,"服务器未知异常",method+" "+requestUrl);
        return unifyResponse; //既然走到这里，那么一定是在controller方法之前返回的
    }






    //===========================.已.知.异.常.==============================
    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration; //为了根据配置文件中的状态码获取对应的message文字

    //一旦controller中抛出的异常类型为HttpException，那么就会进入到这里，而不会进入到上面的异常处理中
    @ExceptionHandler(HttpException.class) //HttpException异常 "value="可以不写   - 已知异常
    //@ResponseBody //该注解使得controller在抛出异常后，可接受到以下函数返回的值
    public ResponseEntity handleHttpException(HttpServletRequest req, HttpException e){
        //一旦controller中抛出了异常，那么程序都会进入到这里
        //参数e就是获取到的错误信息
        //断点可以看到e的异常信息
        String requestUrl = req.getRequestURI();//接口地址
        String method = req.getMethod(); //请求方式


        //上面的未知异常因为有了@Body，所以不用像以下那样去设置:



        //1.配置返回前端的数据：
        int code = e.getCode();
        String message = this.exceptionCodeConfiguration.getMessage(code);
        String request = method+" "+requestUrl;
        UnifyResponse unifyResponse = new UnifyResponse(code,message,request);


        HttpHeaders httpHeaders = new HttpHeaders();

        //2.设置contentType
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //3.设置http状态码
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());


        //通过ResponseEntity对象来设置http状态码等
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(unifyResponse,httpHeaders,httpStatus);

        return r;
    }
}
