package com.exam.nxt.exception;

import com.exam.nxt.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 如果抛出的的是ServiceException，则调用该方法
     * @param exception 业务异常
     * @return Result
     */
    @ExceptionHandler(NxtException.class)
    @ResponseBody
    public Result handle(NxtException exception){
        return Result.error(exception.getCode(), exception.getMessage());
    }
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public Result validException(Exception exception){
        log.warn("传入参数错误");
        return Result.error("500", "传入参数错误");
    }
}
