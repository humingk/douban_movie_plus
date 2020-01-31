package org.humingk.movie.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.common.util.AesUtil;
import org.humingk.movie.common.enumeration.StateAndMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * AES解密切面类
 * <p>
 * 拦截请求,解密参数
 *
 * @author humingk
 */
@Aspect
@Slf4j
@Component
public class AesDecryptAspect {

    /**
     * 切点定义:
     * 使用@AESDecrypt注解的类or方法
     */
    @Pointcut("@within(org.humingk.movie.common.annotation.AesDecrypt) || @annotation(org.humingk.movie.common.annotation.AesDecrypt)")
    public void aesDecryptPointCut() {
    }

    /**
     * 环绕通知:
     * 对controller层方法请求参数解密
     *
     * @param joinPoint
     * @return
     */
    @Around("aesDecryptPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 请求参数key列表
        String[] argsNameArray= ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        // 请求参数value列表
        Object[] args = joinPoint.getArgs();
        try {
            for (int i = 0; i < args.length; i++) {
                // 不需要AES加密的参数： offset、limit
                if(!"offset".equals(argsNameArray[i])&&!"limit".equals(argsNameArray[i])){
                    args[i] = AesUtil.decrypt(args[i].toString());
                }
            }
        } catch (Exception e) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Map logMap = new HashMap() {
                {
                    put("ip", request.getRemoteAddr());
                    put("url", request.getRequestURL());
                    put("args", joinPoint.getArgs());
                }
            };
            log.warn("decrypt failed:" + logMap.toString() + ",reason", e);
            throw new MyException(StateAndMessage.BADREQUEST);
        }
        return joinPoint.proceed(args);
    }
}
