package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CelebrityImdbOfMovieImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.CelebrityImdbOfMovieImdbDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityImdbOfMovieImdbVoConverter
    extends BaseConverter<CelebrityImdbOfMovieImdbVo, CelebrityImdbOfMovieImdbDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "idCelebrityImdb",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getIdCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getUrlCelebrityImdb"}),
    @Mapping(
        target = "idMovieImdb",
        source = "celebrityImdbOfMovieImdbDo.movieImdbToCelebrityImdb.idMovieImdb",
        qualifiedByName = {"ConverterUtil", "getUrlMovieImdb"}),
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"ConverterUtil", "getUrlCelebrityDouban"}),
    @Mapping(
        target = "idProfession",
        source = "celebrityImdbOfMovieImdbDo.movieImdbToCelebrityImdb.idProfession"),
    @Mapping(
        target = "profession",
        source = "celebrityImdbOfMovieImdbDo.movieImdbToCelebrityImdb.idProfession",
        qualifiedByName = {"ConverterUtil", "getProfessionZh"})
  })
  CelebrityImdbOfMovieImdbVo to(CelebrityImdbOfMovieImdbDo celebrityImdbOfMovieImdbDo);
}
