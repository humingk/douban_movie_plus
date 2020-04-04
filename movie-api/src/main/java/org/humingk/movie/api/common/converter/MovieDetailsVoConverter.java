package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.movie.MovieDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieImdbDetailsVoConverter;
import org.humingk.movie.api.common.vo.MovieDetailsVo;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDetailsDto;
import org.humingk.movie.service.imdb.dto.movie.MovieImdbDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanDetailsVoConverter.class, MovieImdbDetailsVoConverter.class})
public interface MovieDetailsVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "movieDoubanDetailsDto"),
    @Mapping(target = "imdb", source = "movieImdbDetailsDto")
  })
  MovieDetailsVo to(
      MovieDoubanDetailsDto movieDoubanDetailsDto, MovieImdbDetailsDto movieImdbDetailsDto);
}
