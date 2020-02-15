package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieImdbVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieImdbVoConverter extends BaseConverter<MovieImdbVo, MovieImdbDto> {
  @Override
  @Mappings({
    @Mapping(
        target = "id",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getIdMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getUrlMovieImdb"}),
    @Mapping(target = "typeVideo", source = "idTypeVideo", qualifiedByName = "toTypeVideo"),
    @Mapping(
        target = "urlPoster",
        expression =
            "java(\"https://m.media-amazon.com/images/M/\" + movieImdbDto.getUrlPoster())"),
  })
  MovieImdbVo to(MovieImdbDto movieImdbDto);

  @Named("toTypeVideo")
  default String toTypeVideo(Byte idTypeVideo) {
    return MovieConstant.VIDEO_TYPE.get(idTypeVideo).get(0);
  }
}
