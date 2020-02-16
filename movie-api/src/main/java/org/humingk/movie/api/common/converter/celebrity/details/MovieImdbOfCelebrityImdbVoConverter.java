package org.humingk.movie.api.common.converter.celebrity.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.celebrity.details.MovieImdbOfCelebrityImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieImdbOfCelebrityImdbVoConverter
    extends BaseConverter<MovieImdbOfCelebrityImdbVo, MovieImdbOfCelebrityImdbDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "id",
        source = "id",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "typeVideo",
        source = "idTypeVideo",
        qualifiedByName = {"util", "typeVideo"}),
    @Mapping(
        target = "urlPoster",
        source = "urlPoster",
        qualifiedByName = {"util", "urlPosterImdb"}),
    @Mapping(target = "idProfession", source = "movieImdbToCelebrityImdb.idProfession"),
    @Mapping(
        target = "profession",
        source = "movieImdbToCelebrityImdb.idProfession",
        qualifiedByName = {"util", "profession"}),
  })
  MovieImdbOfCelebrityImdbVo to(MovieImdbOfCelebrityImdbDo movieImdbOfCelebrityImdbDo);
}
