package com.utils;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


// AOP 的思想
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 指定要处理的异常类
    @ResponseBody
    public Map<String, Object> handleException(Exception exception){
        Map<String, Object> map = new HashMap<>();
        map.put("errCode", "全局异常");
        map.put("errMsg", exception.toString());
        return map;
    }
}
