package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.*;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.AwardOfMovieAndCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.ImageDoubanVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
        qualifiedByName = {"util", "typeList"}),
    @Mapping(
        target = "tagList",
        source = "tagMovieList",
        qualifiedByName = {"util", "tagList"}),
    @Mapping(target = "celebrityList", source = "celebrityDoubanOfMovieDoubanDoList"),
    @Mapping(target = "trailerList", source = "trailerMovieDoubanList"),
    @Mapping(target = "imageList", source = "imageDoubanDoList"),
    @Mapping(target = "classicList", source = "classicDoubanList"),
    @Mapping(target = "reviewList", source = "reviewMovieDoubanList"),
    @Mapping(target = "awardList", source = "awardOfMovieAndCelebrityDoubanDoList"),
    @Mapping(target = "commentList", source = "commentMovieDoubanList")
  })
  MovieDoubanDetailsVo to(MovieDoubanDetailsDto movieDoubanDetailsDto);
}
