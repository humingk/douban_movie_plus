package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.CelebrityImdbOfMovieImdbVoConverter;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieImdbVoConverter;
import org.humingk.movie.api.common.vo.movie.MovieImdbDetailsVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieImdbToTypeMovie;
import org.humingk.movie.service.imdb.dto.movie.MovieImdbDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      MovieImdbVoConverter.class,
      RateMovieImdbVoConverter.class,
      CelebrityImdbOfMovieImdbVoConverter.class
    })
public interface MovieImdbDetailsVoConverter
    extends BaseConverter<MovieImdbDetailsVo, MovieImdbDetailsDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "movieImdb"),
    @Mapping(target = "rate", source = "rateImdb"),
    @Mapping(
        target = "typeList",
        source = "movieImdbToTypeMovieList",
        qualifiedByName = "toTypeList"),
    @Mapping(target = "celebrityList", source = "celebrityImdbOfMovieImdbDoList")
  })
  MovieImdbDetailsVo to(MovieImdbDetailsDto movieImdbDetailsDto);

  @Named("toTypeList")
  default List<String> toTypeList(List<MovieImdbToTypeMovie> movieImdbToTypeMovieList) {
    return movieImdbToTypeMovieList.stream()
        .map(
            movieImdbToTypeMovie ->
                MovieConstant.MOVIE_TYPE.get(movieImdbToTypeMovie.getIdTypeMovie()))
        .collect(Collectors.toList());
  }
}
