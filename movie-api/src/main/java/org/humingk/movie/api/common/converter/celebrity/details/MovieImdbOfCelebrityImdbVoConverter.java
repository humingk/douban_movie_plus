package org.humingk.movie.api.common.converter.celebrity.details;

import org.humingk.movie.api.common.converter.movie.details.MovieImdbToCelebrityImdbVoConverter;
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
    uses = {ConverterUtil.class, MovieImdbToCelebrityImdbVoConverter.class})
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
    @Mapping(target = "relationList", source = "movieImdbToCelebrityImdbList")
  })
  MovieImdbOfCelebrityImdbVo to(MovieImdbOfCelebrityImdbDo movieImdbOfCelebrityImdbDo);
}
