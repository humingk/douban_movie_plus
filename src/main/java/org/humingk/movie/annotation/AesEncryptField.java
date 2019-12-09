package org.humingk.movie.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 @AesEncryptField AES加密注解
 * 作用位置:    字段
 * 作用时间:    运行时
 * 优先级:     最高
 *
 * @author humingk
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface AesEncryptField {
}
