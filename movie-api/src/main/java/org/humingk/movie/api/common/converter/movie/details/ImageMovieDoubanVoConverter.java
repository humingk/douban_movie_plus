package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.vo.movie.details.ImageMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ImageMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ImageMovieDoubanVoConverter
    extends BaseConverter<ImageMovieDoubanVo, ImageMovieDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlImageSqxs",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/sqxs/public/p\"+imageMovieDouban.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageS",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/s/public/p\"+imageMovieDouban.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageM",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/m/public/p\"+imageMovieDouban.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageL",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/l/public/p\"+imageMovieDouban.getId()+\".webp\")"),
  })
  ImageMovieDoubanVo to(ImageMovieDouban imageMovieDouban);
}
