package org.humingk.movie.api.common.converter.movie.rate;

import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.RateMovieDouban;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface RateMovieDoubanVoConverter
    extends BaseConverter<RateMovieDoubanVo, RateMovieDouban> {}
