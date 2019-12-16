package org.humingk.movie.advice;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.Result;
import org.humingk.movie.exception.MyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局自定义异常处理类
 * <p>
 * 拦截Controller层中抛出的自定义异常,包括service层
 * <p>
 * Order:   最先处理
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
     * 自定义异常需要主动抛出
     * <p>
     * PS: 自定义异常选择性打印错误日志,在抛出异常处打印
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result myExceptionHandler(MyException e) {
        log.error("已知异常,status:" + e.getStatus() + " ,message:{}", e.getMessage());
        return Result.error(e);
    }

    /**
     * 404 not found
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result notFoundExceptionHandler(HttpServletRequest request, Exception e) {
        log.warn("找不到此页面,url:" + request.getRequestURI(), e);
        return Result.notFound();
    }
}