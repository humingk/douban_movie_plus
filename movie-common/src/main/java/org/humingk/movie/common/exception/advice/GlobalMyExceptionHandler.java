package org.humingk.movie.common.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.exception.MyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局自定义异常处理类
 * <p>
 * 在Controller层中拦截所有抛出的自定义异常,用于日志记录和前端返回
 * <p>
 * Order:   优先级最低
 *
 * @author humingk
 */
@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalMyExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 自定义异常
     * <p>
     * 自定义异常需要主动抛出(包括已知错误，部分未知错误)
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result<Object> myExceptionHandler(MyException e) {
        log.error("已知异常,{},{}:{}", e.getStatus(), e.getMessage(), e.getData());
        return Result.error(e);
    }
}