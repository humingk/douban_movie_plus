package org.humingk.movie.api.common.util;

import java.util.List;

/**
 * VO转换映射接口
 *
 * @param <S> 原始Pojo
 * @param <T> 目标Pojo
 * @author humingk
 */
public interface BaseVoConverter<S, T> {
    T to(S s);

    List<T> to(List<S> sList);
}
