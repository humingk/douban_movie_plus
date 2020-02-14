package org.humingk.movie.common.util;

import java.util.List;

/**
 * Pojo转换基础接口2
 *
 * @param <T> 目标Pojo
 * @param <S1> 原始Pojo1
 * @param <S2> 原始Pojo2
 * @author humingk
 */
public interface Base2Converter<T, S1, S2> {
  T to(S1 s1, S2 s2);

  List<T> toList(List<S1> s1List, List<S2> s2List);
}
