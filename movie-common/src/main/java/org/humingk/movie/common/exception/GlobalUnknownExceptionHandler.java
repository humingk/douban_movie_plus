package org.humingk.movie.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.entity.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局未知异常处理类
 *
 * <p>在Controller层中拦截所有抛出的未知异常,用于日志记录和前端返回
 *
 * <p>优先级需要比其他已知异常更低
 *
 * @author humingk
 */
@Slf4j
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class GlobalUnknownExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * 未知异常
   *
   * <p>未知异常均为被动抛出
   *
   * @param e
   * @return
   */
  @ExceptionHandler(Exception.class)
  public Result handleUnknownException(Exception e) {
    log.error("未知异常:{}", e.getMessage(), e);
    return Result.error(e.getMessage());
  }
}
