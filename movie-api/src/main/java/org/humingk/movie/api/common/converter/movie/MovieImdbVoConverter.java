package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieImdbVoConverter extends BaseConverter<MovieImdbVo, MovieImdb> {
  @Override
  @Mappings({
    @Mapping(
        target = "id",
        source = "id",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "id",
        qualifiedByName = {"util", "urlMovieImdb"}),
    @Mapping(
        target = "typeVideo",
        source = "idTypeVideo",
        qualifiedByName = {"util", "typeVideo"}),
    @Mapping(
        target = "urlPoster",
        source = "urlPoster",
        qualifiedByName = {"util", "urlPosterImdb"}),
  })
  MovieImdbVo to(MovieImdb movieImdb);
}
