package com.whj.springbootcode.core;

import com.whj.springbootcode.core.configuration.ExceptionCodeConfiguration;
import com.whj.springbootcode.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.net.HttpRetryException;
import java.util.List;

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







    //===========================.前端BODY体参数校验异常.==============================
    @ExceptionHandler(MethodArgumentNotValidException.class)//处理异常 - 前端body体参数校验异常
    @ResponseBody //该注解使得controller在抛出异常后，可接受到以下函数返回的值
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //400参数异常的http状态码 手动设置http状态码
    public UnifyResponse handleBeanValidation(HttpServletRequest req,MethodArgumentNotValidException e){
        String requestUrl = req.getRequestURI();//接口地址
        String method = req.getMethod(); //请求方式

        //可以断点查看错误信息: 有几处参数校验错误就会打印出几条错误信息来
        List<ObjectError> errors = e.getBindingResult().getAllErrors();//通过e获取所有校验异常信息
        String message = formatAllErrorsMessages(errors);

        //所有参数校验异常的code码都是一样的，定为10001
        String request = method+" "+requestUrl;
        return new UnifyResponse(10001,message,request);
    }

    /**
     * 将多个前端body体中的参数校验异常中的message拼接成一个字符串,以分号隔开
     * @param errors
     * @return
     */
    private String formatAllErrorsMessages(List<ObjectError> errors){
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error->errorMsg.append(error.getDefaultMessage()).append(';'));
        return errorMsg.toString();
    }








    //===========================.前端URL参数校验异常.==============================
    @ExceptionHandler(ConstraintViolationException.class)//处理异常 - 前端url参数校验异常
    @ResponseBody //该注解使得controller在抛出异常后，可接受到以下函数返回的值
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //400参数异常的http状态码 手动设置http状态码
    public UnifyResponse handleConstraintException(HttpServletRequest req, ConstraintViolationException e){
        String requestUrl = req.getRequestURI();//接口地址
        String method = req.getMethod(); //请求方式

        //通过e获取所有校验异常信息 最好使用循环的方式获取异常信息，这样定制化更强一些
//        for (ConstraintViolation error: e.getConstraintViolations()){
//            ConstraintViolation a = error;
//        }
        String request = method+" "+requestUrl;
        String message = e.getMessage();
        return new UnifyResponse(10001,message,request);
    }





    //===========================.前端的请求方式与后端要求的不符.==============================
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)//处理异常 - 前端url参数校验异常
    @ResponseBody //该注解使得controller在抛出异常后，可接受到以下函数返回的值
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED) //405 请求方式错误，要求GET，但是使用了POST方式请求
    public UnifyResponse handleConstraintException(HttpServletRequest req, HttpRequestMethodNotSupportedException e){
        String requestUrl = req.getRequestURI();//接口地址
        String method = req.getMethod(); //请求方式
        String request = method+" "+requestUrl;
        return new UnifyResponse(10002,"前端请求方式错误",request);
    }
}
