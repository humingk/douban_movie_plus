package org.humingk.movie.service.imdb.converter.celebrity;

import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDetailsDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface CelebrityImdbDetailsDtoConverter {
  CelebrityImdbDetailsDto to(
      /** IMDB影人基础信息 */
      CelebrityImdb celebrityImdb,
      /** 与IMDB影人相关的IMDB电影 */
      List<MovieImdbOfCelebrityImdbDo> movieImdbOfCelebrityImdbDoList);
}
