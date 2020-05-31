package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.MovieDoubanToCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieDoubanToCelebrityDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieDoubanToCelebrityDoubanVoConverter
    extends BaseConverter<MovieDoubanToCelebrityDoubanVo, MovieDoubanToCelebrityDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "profession",
        source = "idProfession",
        qualifiedByName = {"util", "profession"}),
  })
  MovieDoubanToCelebrityDoubanVo to(MovieDoubanToCelebrityDouban movieDoubanToCelebrityDouban);
}
