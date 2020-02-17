package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.movie.MovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieImdbVoConverter;
import org.humingk.movie.api.common.vo.MovieVo;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDto;
import org.humingk.movie.service.imdb.dto.movie.MovieImdbDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanVoConverter.class, MovieImdbVoConverter.class})
public interface MovieVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "movieDoubanDto"),
    @Mapping(target = "imdb", source = "movieImdbDto")
  })
  MovieVo to(MovieDoubanDto movieDoubanDto, MovieImdbDto movieImdbDto);
}
