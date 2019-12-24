package org.humingk.common.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.humingk.common.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局未知异常处理类
 * <p>
 * 拦截Controller层中抛出的未知异常,包括service层
 *
 * @author humingk
 */
@Slf4j
@RestControllerAdvice
public class GlobalUnknownExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 未知异常
     * <p>
     * 未知异常为被动抛出
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error("未知异常:" + e.getMessage(), e);
        return Result.error();
    }
}