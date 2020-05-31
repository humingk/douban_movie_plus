package org.humingk.movie.common.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 自定义AES解密注解
 *
 * <p>作用位置: 类 方法
 *
 * <p>作用时间: 运行时
 *
 * @author humingk
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface AesDecrypt {}
