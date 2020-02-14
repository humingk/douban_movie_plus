package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.TrailerMovieDoubanVoConverter;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.dal.entity.TagMovie;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

/** @author humingk */
@Validated
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanVoConverter.class, TrailerMovieDoubanVoConverter.class})
public interface MovieDoubanDetailsVoConverter {

  //  @Mappings({
  //    @Mapping(target = "baseInfo", source = "movieDoubanDto"),
  //    @Mapping(
  //        target = "aliasList",
  //        source = "aliasMovieDoubanList",
  //        qualifiedByName = "toAliasList"),
  //    @Mapping(target = "tagList", source = "tagMovieList", qualifiedByName = "toTagList"),
  //    @Mapping(target = "typeList", source = "movieDoubanToTypeMovieList"),
  //    @Mapping(
  //        target = "trailerList",
  //        source = "trailerMovieDoubanList",
  //        qualifiedByName = {"TrailerMovieDoubanVoConverter", "toList"})
  //  })
  //  MovieDoubanDetailsVo to(
  //      @NotNull MovieDoubanDto movieDoubanDto,
  //      List<AliasMovieDouban> aliasMovieDoubanList,
  //      List<TagMovie> tagMovieList,
  //      List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList,
  //      List<TrailerMovieDouban> trailerMovieDoubanList);

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

  default String toType(MovieDoubanToTypeMovie movieDoubanToTypeMovie) {
    return MovieConstant.MOVIE_TYPE.get(movieDoubanToTypeMovie.getIdTypeMovie());
  }
}
