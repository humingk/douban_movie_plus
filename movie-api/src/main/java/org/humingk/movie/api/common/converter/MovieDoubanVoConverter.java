package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.vo.MovieDoubanVo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.mapstruct.Mapper;

/**
 * @author humingk
 */
@Mapper(componentModel = "spring")
public interface MovieDoubanVoConverter extends BaseConverter<MovieDouban, MovieDoubanVo> {
    @Override
    default void update(MovieDouban movieDouban, MovieDoubanVo movieDoubanVo) {
        movieDoubanVo.setTypeVideo(String.valueOf(movieDouban.getIdTypeVideo())+" type");
    }
}
