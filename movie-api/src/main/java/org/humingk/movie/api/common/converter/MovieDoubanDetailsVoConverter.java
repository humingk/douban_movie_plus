package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.entity.Constant;
import org.humingk.movie.api.common.vo.MovieDoubanDetailsVo;
import org.humingk.movie.dal.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanVoConverter.class, TrailerMovieDoubanVoConverter.class})
public interface MovieDoubanDetailsVoConverter {

  @Mappings({
    @Mapping(target = "baseInfo", source = "movieDouban"),
    @Mapping(
        target = "aliasList",
        source = "aliasMovieDoubanList",
        qualifiedByName = "toAliasList"),
    @Mapping(target = "tagList", source = "tagMovieList", qualifiedByName = "toTagList"),
    @Mapping(target = "typeList", source = "movieDoubanToTypeMovieList"),
    @Mapping(
        target = "trailerList",
        source = "trailerMovieDoubanList",
        qualifiedByName = {"TrailerMovieDoubanVoConverter", "toList"})
  })
  MovieDoubanDetailsVo to(
      @NotNull MovieDouban movieDouban,
      List<AliasMovieDouban> aliasMovieDoubanList,
      List<TagMovie> tagMovieList,
      List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList,
      List<TrailerMovieDouban> trailerMovieDoubanList);

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
    return Constant.MOVIE_TYPE.get(movieDoubanToTypeMovie.getIdTypeMovie());
  }
}
