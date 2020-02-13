package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.entity.Constant;
import org.humingk.movie.api.common.vo.MovieDoubanVo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.validation.constraints.NotNull;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieDoubanVoConverter {

  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        expression = "java(\"https://movie.douban.com/subject/\"+movieDouban.getId())"),
    @Mapping(target = "typeVideo", source = "idTypeVideo"),
    @Mapping(
        target = "idMovieImdb",
        expression =
            "java(movieDouban.getIdMovieImdb() == 0 || movieDouban.getIdMovieImdb() == 1 ? \"\" : \"tt\" + movieDouban.getIdMovieImdb())"),
    @Mapping(
        target = "urlMovieImdb",
        expression =
            "java(movieDouban.getIdMovieImdb()==0 ||movieDouban.getIdMovieImdb()==1?\"\":\"https://www.imdb.com/title/tt\"+movieDouban.getIdMovieImdb())"),
    @Mapping(
        target = "urlPoster",
        expression =
            "java(\"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p\" + movieDouban.getUrlPoster() + \".webp\")")
  })
  MovieDoubanVo to(@NotNull MovieDouban movieDouban);

  default String toTypeVideo(Byte idTypeVideo) {
    return Constant.VIDEO_TYPE.get(idTypeVideo);
  }
}
