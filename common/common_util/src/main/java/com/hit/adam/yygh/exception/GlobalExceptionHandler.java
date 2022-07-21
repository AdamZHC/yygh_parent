package com.hit.adam.yygh.exception;


import com.hit.adam.yygh.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//固定的异常处理的Controller
//类似于配置类
@ControllerAdvice
public class GlobalExceptionHandler {

    //定义异常的类型
    //返回一个json的格式响应
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(MyHospitalException.class)
    @ResponseBody
    public Result error(MyHospitalException e) {
        e.printStackTrace();
        return Result.fail();
    }
}
