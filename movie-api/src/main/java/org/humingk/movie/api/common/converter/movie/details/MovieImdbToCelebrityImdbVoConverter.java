package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.MovieImdbToCelebrityImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieImdbToCelebrityImdbVoConverter
    extends BaseConverter<MovieImdbToCelebrityImdbVo, MovieImdbToCelebrityImdb> {
  @Override
  @Mappings({
    @Mapping(
        target = "profession",
        source = "idProfession",
        qualifiedByName = {"util", "profession"}),
  })
  MovieImdbToCelebrityImdbVo to(MovieImdbToCelebrityImdb movieImdbToCelebrityImdb);
}
