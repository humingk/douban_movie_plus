package org.humingk.movie.common.annotation;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义Redis缓存注解
 *
 * <p>作用位置: 类 方法
 *
 * <p>作用时间: 运行时
 *
 * @author humingk
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Cacheable(value = "douban_movie_plus")
public @interface RedisCache {}
