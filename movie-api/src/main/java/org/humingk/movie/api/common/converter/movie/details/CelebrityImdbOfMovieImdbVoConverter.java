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
        qualifiedByName = {"util", "idCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "id",
        qualifiedByName = {"util", "urlCelebrityImdb"}),
    @Mapping(
        target = "idMovieImdb",
        source = "movieImdbToCelebrityImdb.idMovieImdb",
        qualifiedByName = {"util", "urlMovieImdb"}),
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
    @Mapping(target = "idProfession", source = "movieImdbToCelebrityImdb.idProfession"),
    @Mapping(
        target = "profession",
        source = "movieImdbToCelebrityImdb.idProfession",
        qualifiedByName = {"util", "profession"})
  })
  CelebrityImdbOfMovieImdbVo to(CelebrityImdbOfMovieImdbDo celebrityImdbOfMovieImdbDo);
}
