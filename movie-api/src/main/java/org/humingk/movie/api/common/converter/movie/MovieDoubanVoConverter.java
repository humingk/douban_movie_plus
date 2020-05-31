package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieDoubanVoConverter extends BaseConverter<MovieDoubanVo, MovieDouban> {

  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        source = "id",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(
        target = "typeVideo",
        source = "idTypeVideo",
        qualifiedByName = {"util", "typeVideo"}),
    @Mapping(
        target = "idMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"util", "urlMovieImdb"}),
    @Mapping(
        target = "urlPoster",
        source = "urlPoster",
        qualifiedByName = {"util", "urlPoster"})
  })
  MovieDoubanVo to(MovieDouban movieDouban);
}
