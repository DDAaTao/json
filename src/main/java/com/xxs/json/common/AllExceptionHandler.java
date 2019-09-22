package com.xxs.json.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截器
 * @author van
 */
@Slf4j
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult allException(Exception e){
        log.error(String.format("统一异常拦截 errorCode : %s ; errorMessage : %s."
                , ResultCode.SYSTEM_ERROR.getCode(), e.getMessage()));
        return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
