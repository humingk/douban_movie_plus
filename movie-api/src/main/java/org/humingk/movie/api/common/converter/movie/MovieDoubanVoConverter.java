package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieDoubanVoConverter extends BaseConverter<MovieDoubanVo, MovieDoubanDto> {

  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        expression = "java(\"https://movie.douban.com/subject/\"+movieDoubanDto.getId())"),
    @Mapping(target = "typeVideo", source = "idTypeVideo", qualifiedByName = "toTypeVideo"),
    @Mapping(
        target = "idMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"ConverterUtil", "getIdMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"ConverterUtil", "getUrlMovieImdb"}),
    @Mapping(
        target = "urlPoster",
        expression =
            "java(\"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p\" + movieDoubanDto.getUrlPoster() + \".webp\")")
  })
  MovieDoubanVo to(MovieDoubanDto movieDoubanDto);

  @Named("toTypeVideo")
  default String toTypeVideo(Byte idTypeVideo) {
    return MovieConstant.VIDEO_TYPE.get(idTypeVideo).get(0);
  }
}
