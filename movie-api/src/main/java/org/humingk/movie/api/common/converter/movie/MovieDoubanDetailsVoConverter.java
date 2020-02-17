package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.*;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.AwardOfMovieAndCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.ImageDoubanVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.dal.entity.TagMovie;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDetailsDto;
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
      ConverterUtil.class,
      MovieDoubanVoConverter.class,
      RateMovieDoubanVoConverter.class,
      CelebrityDoubanOfMovieDoubanVoConverter.class,
      TrailerMovieDoubanVoConverter.class,
      ImageDoubanVoConverter.class,
      ClassicDoubanVoConverter.class,
      ReviewMovieDoubanVoConverter.class,
      AwardOfMovieAndCelebrityDoubanVoConverter.class,
      CommentMovieDoubanVoConverter.class
    })
public interface MovieDoubanDetailsVoConverter {

  @Mappings({
    @Mapping(target = "base", source = "movieDoubanDto"),
    @Mapping(target = "rate", source = "rateMovieDouban"),
    @Mapping(
        target = "aliasList",
        source = "aliasMovieDoubanList",
        qualifiedByName = {"util", "aliasList"}),
    @Mapping(
        target = "typeList",
        source = "movieDoubanToTypeMovieList",
        qualifiedByName = "toTypeList"),
    @Mapping(target = "tagList", source = "tagMovieList", qualifiedByName = "toTagList"),
    @Mapping(target = "celebrityList", source = "celebrityDoubanOfMovieDoubanDoList"),
    @Mapping(target = "trailerList", source = "trailerMovieDoubanList"),
    @Mapping(target = "imageList", source = "imageDoubanDoList"),
    @Mapping(target = "classicList", source = "classicDoubanList"),
    @Mapping(target = "reviewList", source = "reviewMovieDoubanList"),
    @Mapping(target = "awardList", source = "awardOfMovieAndCelebrityDoubanDoList"),
    @Mapping(target = "commentList", source = "commentMovieDoubanList")
  })
  MovieDoubanDetailsVo to(MovieDoubanDetailsDto movieDoubanDetailsDto);

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
