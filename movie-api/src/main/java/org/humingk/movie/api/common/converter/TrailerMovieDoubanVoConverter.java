package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.vo.TrailerMovieDoubanVo;
import org.humingk.movie.dal.entity.TrailerMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import javax.validation.constraints.NotNull;
import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
@Named("TrailerMovieDoubanVoConverter")
public interface TrailerMovieDoubanVoConverter {

  @Mappings({
    @Mapping(
        target = "urlTrailer",
        expression = "java(\"https://movie.douban.com/trailer/\"+trailerMovieDouban.getId())")
  })
  TrailerMovieDoubanVo to(@NotNull TrailerMovieDouban trailerMovieDouban);

  @Named("toList")
  List<TrailerMovieDoubanVo> toList(List<TrailerMovieDouban> trailerMovieDoubanList);
}
