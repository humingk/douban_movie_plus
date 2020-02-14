package org.humingk.movie.service.imdb.common.converter;

import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;
import org.humingk.movie.dal.entity.MovieImdbToTypeMovie;
import org.humingk.movie.dal.entity.RateImdb;
import org.humingk.movie.service.imdb.common.dto.MovieImdbDetailsDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieImdbDetailsDtoConverter {
  MovieImdbDetailsDto to(
      /** IMDB电影基础信息 */
      MovieImdb movieImdb,
      /** IMDB电影评分信息（包括烂番茄、MTC） */
      RateImdb rateImdb,
      /** IMDB电影-类型列表 */
      List<MovieImdbToTypeMovie> movieImdbToTypeMovieList,
      /** IMDB电影-影人列表 */
      List<MovieImdbToCelebrityImdb> movieImdbToCelebrityImdbList);
}
