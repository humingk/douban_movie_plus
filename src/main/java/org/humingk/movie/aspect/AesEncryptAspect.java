package org.humingk.movie.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.humingk.movie.tool.AesUtils;
import org.springframework.stereotype.Component;

/**
 * AES解密切面类,拦截请求
 * 对应类或方法添加 @AesEncrypt 注解
 *
 * @author humingk
 */
@Aspect
@Component
public class AesEncryptAspect {

    /**
     * 前置通知,对请求参数解密
     *
     * @param joinPoint
     * @return
     */
    @Before(value = "@annotation(org.humingk.movie.annotation.AesEncrypt)")
    public void doBefore(ProceedingJoinPoint joinPoint) {
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        String decrypt_text = "";
        try {
            decrypt_text = AesUtils.decrypt(args[0].toString(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        args[0] = decrypt_text;
    }
}
