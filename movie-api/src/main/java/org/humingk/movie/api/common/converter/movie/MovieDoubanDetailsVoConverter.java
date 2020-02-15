package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.*;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.dal.entity.TagMovie;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDetailsDto;
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
      MovieDoubanVoConverter.class,
      RateMovieDoubanVoConverter.class,
      CelebrityDoubanOfMovieDoubanVoConverter.class,
      TrailerMovieDoubanVoConverter.class,
      ImageMovieDoubanVoConverter.class,
      ClassicDoubanVoConverter.class,
      ReviewMovieDoubanVoConverter.class,
      AwardOfMovieDoubanVoConverter.class,
      CommentMovieDoubanVoConverter.class
    })
public interface MovieDoubanDetailsVoConverter {

  @Mappings({
    @Mapping(target = "base", source = "movieDoubanDetailsDto.movieDoubanDto"),
    @Mapping(target = "rate", source = "rateMovieDouban"),
    @Mapping(
        target = "aliasList",
        source = "aliasMovieDoubanList",
        qualifiedByName = "toAliasList"),
    @Mapping(
        target = "typeList",
        source = "movieDoubanToTypeMovieList",
        qualifiedByName = "toTypeList"),
    @Mapping(target = "tagList", source = "tagMovieList", qualifiedByName = "toTagList"),
    @Mapping(target = "celebrityList", source = "celebrityDoubanOfMovieDoubanDoList"),
    @Mapping(target = "trailerList", source = "trailerMovieDoubanList"),
    @Mapping(target = "imageList", source = "imageMovieDoubanList"),
    @Mapping(target = "classicList", source = "classicDoubanList"),
    @Mapping(target = "reviewList", source = "reviewMovieDoubanList"),
    @Mapping(target = "awardList", source = "awardOfMovieDoubanDoList"),
    @Mapping(target = "commentList", source = "commentMovieDoubanList")
  })
  MovieDoubanDetailsVo to(MovieDoubanDetailsDto movieDoubanDetailsDto);

  @Named("toAliasList")
  default List<String> toAliasList(List<AliasMovieDouban> aliasMovieDoubanList) {
    return aliasMovieDoubanList.stream()
        .map(AliasMovieDouban::getNameAlias)
        .collect(Collectors.toList());
  }

  @Named("toTagList")
  default List<String> toTagList(List<TagMovie> tagMovieList) {
    return tagMovieList.stream().map(TagMovie::getNameZh).collect(Collectors.toList());
  }

  @Named("toTypeList")
  default List<String> toTypeList(List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList) {
    return movieDoubanToTypeMovieList.stream()
        .map(
            movieDoubanToTypeMovie ->
                MovieConstant.MOVIE_TYPE.get(movieDoubanToTypeMovie.getIdTypeMovie()))
        .collect(Collectors.toList());
  }
}
