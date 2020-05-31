package org.humingk.movie.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 日志切面类
 *
 * <p>用于日志记录方法调用（主要为Controller层的方法）
 *
 * @author humingk
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

  /** 当前服务的端口号 */
  @Value("${server.port}")
  private String port;

  /** 切入点: 使用@LogRecord注解的类or方法 */
  @Pointcut(
      "@within(org.humingk.movie.common.annotation.LogRecord) || @annotation(org.humingk.movie.common.annotation.LogRecord)")
  public void controllerPointCut() {}

  /**
   * 前置通知: controller层所有方法调用日志,记录请求信息
   *
   * @param joinPoint
   */
  @Before("controllerPointCut()")
  public void doBefore(JoinPoint joinPoint) {
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
    // server中，拦截@LogRecord注解下的方法调用
    log.info(
        "server's request: url={},ip={},args={},method={},port={}",
        request.getRequestURI(),
        request.getRemoteAddr(),
        joinPoint.getArgs(),
        joinPoint.getSignature().getName(),
        port);
  }
}
