package org.humingk.movie.api.common.converter;

import java.util.List;

/**
 * Pojo转换基本接口
 *
 * @param <SOURCE> 原始Pojo
 * @param <TARGET> 转换Pojo
 * @author humingk
 */
public interface BaseConverter<SOURCE, TARGET> {
    TARGET to(SOURCE source);

    void update(SOURCE source, TARGET target);

    List<TARGET> toList(List<SOURCE> sourceList);

    SOURCE from(TARGET target);

    List<SOURCE> fromList(List<TARGET> targetList);
}
