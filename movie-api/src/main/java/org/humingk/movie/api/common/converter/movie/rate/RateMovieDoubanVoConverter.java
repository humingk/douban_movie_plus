package org.humingk.movie.api.common.converter.movie.rate;

import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.RateMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface RateMovieDoubanVoConverter
    extends BaseConverter<RateMovieDoubanVo, RateMovieDouban> {
  @Mappings({@Mapping(target = "rateColor", constant = "214,133,9")})
  @Override
  RateMovieDoubanVo to(RateMovieDouban rateMovieDouban);
}
