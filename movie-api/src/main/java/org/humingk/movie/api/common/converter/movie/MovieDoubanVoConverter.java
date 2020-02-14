package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/** @author humingk */
@Validated
@Mapper(componentModel = "spring")
public interface MovieDoubanVoConverter extends BaseConverter<MovieDoubanVo, MovieDoubanDto> {

  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        expression = "java(\"https://movie.douban.com/subject/\"+movieDoubanDto.getId())"),
    @Mapping(target = "typeVideo", source = "idTypeVideo", qualifiedByName = "toTypeVideo"),
    @Mapping(target = "idMovieImdb", source = "idMovieImdb", qualifiedByName = "toIdMovieImdb"),
    @Mapping(target = "urlMovieImdb", source = "idMovieImdb", qualifiedByName = "toUrlMovieImdb"),
    @Mapping(
        target = "urlPoster",
        expression =
            "java(\"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p\" + movieDoubanDto.getUrlPoster() + \".webp\")")
  })
  MovieDoubanVo to(@NotNull MovieDoubanDto movieDoubanDto);

  @Named("toTypeVideo")
  default String toTypeVideo(Byte idTypeVideo) {
    return MovieConstant.VIDEO_TYPE.get(idTypeVideo).get(0);
  }

  @Named("toIdMovieImdb")
  default String toIdMovieImdb(Long idMovieImdb) {
    return idMovieImdb == 0 || idMovieImdb == 1 ? "" : "tt" + String.format("%07d", idMovieImdb);
  }

  @Named("toUrlMovieImdb")
  default String toUrlMovieImdb(Long idMovieImdb) {
    return "https://www.imdb.com/title/" + toIdMovieImdb(idMovieImdb);
  }
}
