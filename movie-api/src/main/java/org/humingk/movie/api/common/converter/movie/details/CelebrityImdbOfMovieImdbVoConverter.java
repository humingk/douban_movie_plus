package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CelebrityImdbOfMovieImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.CelebrityImdbOfMovieImdbDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class, MovieImdbToCelebrityImdbVoConverter.class})
public interface CelebrityImdbOfMovieImdbVoConverter
    extends BaseConverter<CelebrityImdbOfMovieImdbVo, CelebrityImdbOfMovieImdbDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "idCelebrityImdb",
        source = "id",
        qualifiedByName = {"util", "idCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "id",
        qualifiedByName = {"util", "urlCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
    @Mapping(target = "relationList", source = "movieImdbToCelebrityImdbList")
  })
  CelebrityImdbOfMovieImdbVo to(CelebrityImdbOfMovieImdbDo celebrityImdbOfMovieImdbDo);
}
