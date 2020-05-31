package org.humingk.movie.common.util;

import java.util.List;

/**
 * Pojo转换基础接口
 *
 * @param <T> 目标Pojo
 * @param <S> 原始Pojo
 * @author humingk
 */
public interface BaseConverter<T, S> {
  T to(S s);

  S from(T t);

  List<T> toList(List<S> sList);

  List<S> fromList(List<T> tList);
}
