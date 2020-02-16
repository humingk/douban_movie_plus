package org.humingk.movie.service.imdb.common.converter.celebrity;

import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.service.imdb.common.dto.celebrity.CelebrityImdbDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityImdbDtoConverter.class})
public interface CelebrityImdbDetailsDtoConverter {
  @Mappings({@Mapping(target = "celebrityImdbDto", source = "celebrityImdb")})
  CelebrityImdbDetailsDto to(
      /** IMDB影人基础信息 */
      CelebrityImdb celebrityImdb,
      /** 与IMDB影人相关的IMDB电影 */
      List<MovieImdbOfCelebrityImdbDo> movieImdbOfCelebrityImdbDoList);
}
