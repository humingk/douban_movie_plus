package org.humingk.movie.api.common.converter.share;

import org.humingk.movie.api.common.vo.share.ImageDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.ImageDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ImageDoubanVoConverter extends BaseConverter<ImageDoubanVo, ImageDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlImageSqxs",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/sqxs/public/p\"+imageDoubanDo.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageS",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/s/public/p\"+imageDoubanDo.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageM",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/m/public/p\"+imageDoubanDo.getId()+\".webp\")"),
    @Mapping(
        target = "urlImageL",
        expression =
            "java(\"https://img3.doubanio.com/view/photo/l/public/p\"+imageDoubanDo.getId()+\".webp\")"),
  })
  ImageDoubanVo to(ImageDoubanDo imageDoubanDo);
}
