package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.movie.MovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieImdbVoConverter;
import org.humingk.movie.api.common.vo.MovieVo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.MovieImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanVoConverter.class, MovieImdbVoConverter.class})
public interface MovieVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "movieDouban"),
    @Mapping(target = "imdb", source = "movieImdb")
  })
  MovieVo to(MovieDouban movieDouban, MovieImdb movieImdb);
}
