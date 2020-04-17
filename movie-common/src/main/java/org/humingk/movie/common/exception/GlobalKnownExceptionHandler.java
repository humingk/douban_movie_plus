package org.humingk.movie.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.humingk.movie.common.entity.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;

import static org.humingk.movie.common.enumeration.CodeAndMsg.PARAMTER;

/**
 * 全局已知异常处理类
 *
 * <p>在Controller层中拦截所有抛出的已知异常,用于日志记录和前端返回
 *
 * @author humingk
 */
@Slf4j
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 10)
public class GlobalKnownExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * 自定义异常
   *
   * <p>自定义异常需要主动抛出(包括已知错误，部分未知错误)
   *
   * @param e
   * @return
   */
  @ExceptionHandler(MyException.class)
  public Result<Object> handleMyException(MyException e) {
    log.error("已知异常:{},{}", e.getCode(), e.getMsg());
    return Result.error(e);
  }

  /**
   * IO中断异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ClientAbortException.class)
  public void handleClientAbortException(ClientAbortException e) {
    log.warn("已知异常:io中断,{}", e.getMessage());
  }

  /**
   * 方法参数校验异常
   *
   * @param ex
   * @param headers
   * @param status
   * @param request
   * @return
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    return handleExceptionInternal(
        ex, Result.error(PARAMTER), headers, HttpStatus.BAD_REQUEST, request);
  }

  /**
   * 校验异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ValidationException.class)
  public Result<Object> handleValidationException(ValidationException e) {
    log.error("校验异常:{}", e.getMessage());
    return Result.error(PARAMTER);
  }

  /**
   * 约束校验异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public Result<Object> handleConstraintViolationException(ConstraintViolationException e) {
    log.error("约束校验异常:{}", e.getMessage());
    return Result.error(PARAMTER);
  }
}
