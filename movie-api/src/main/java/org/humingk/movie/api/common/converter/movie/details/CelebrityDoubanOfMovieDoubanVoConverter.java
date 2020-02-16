package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CelebrityDoubanOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.CelebrityDoubanOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityDoubanOfMovieDoubanVoConverter
    extends BaseConverter<CelebrityDoubanOfMovieDoubanVo, CelebrityDoubanOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        source = "id",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
    @Mapping(
        target = "idCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"util", "idCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"util", "urlCelebrityImdb"}),
    @Mapping(
        target = "sex",
        source = "sex",
        qualifiedByName = {"util", "sex"}),
    @Mapping(
        target = "birthDate",
        source = "birthDate",
        qualifiedByName = {"util", "unixTimestamp"}),
    @Mapping(
        target = "urlPortrait",
        source = "urlPortrait",
        qualifiedByName = {"util", "urlPortrait"}),
    @Mapping(target = "idProfession", source = "movieDoubanToCelebrityDouban.idProfession"),
    @Mapping(
        target = "profession",
        source = "movieDoubanToCelebrityDouban.idProfession",
        qualifiedByName = {"util", "profession"}),
    @Mapping(target = "sort", source = "movieDoubanToCelebrityDouban.sort")
  })
  CelebrityDoubanOfMovieDoubanVo to(CelebrityDoubanOfMovieDoubanDo celebrityDoubanOfMovieDoubanDo);
}
