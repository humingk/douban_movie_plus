package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.vo.movie.MovieImdbVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.imdb.common.dto.MovieImdbDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/** @author humingk */
@Validated
@Mapper(componentModel = "spring")
public interface MovieImdbVoConverter extends BaseConverter<MovieImdbVo, MovieImdbDto> {
  @Override
  @Mappings({
    @Mapping(target = "id", source = "id", qualifiedByName = "toId"),
    @Mapping(target = "typeVideo", source = "idTypeVideo", qualifiedByName = "toTypeVideo"),
    @Mapping(
        target = "urlPoster",
        expression = "java(\"https://m.media-amazon.com/images/M/\" + movieImdbDto.getUrlPoster())")
  })
  MovieImdbVo to(@NotNull MovieImdbDto movieImdbDto);

  @Named("toId")
  default String toId(Long id) {
    return "tt" + String.format("%07d", id);
  }

  @Named("toTypeVideo")
  default String toTypeVideo(Byte idTypeVideo) {
    return MovieConstant.VIDEO_TYPE.get(idTypeVideo).get(0);
  }
}
