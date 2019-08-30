package com.shadow.config;

import com.shadow.common.exception.ShadowException;
import com.shadow.common.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用异常处理
 * @author Shadow
 * @date 2019/6/20 10:10
 */
@RestControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler(Exception.class)
    public R fallback(Exception e){

        return R.error();
    }

    @ExceptionHandler(ShadowException.class)
    public R shadowEx(ShadowException e){

        return R.error(e);
    }
}
