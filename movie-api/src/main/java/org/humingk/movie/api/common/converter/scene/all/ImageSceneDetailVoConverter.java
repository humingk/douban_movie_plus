package org.humingk.movie.api.common.converter.scene.all;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.ImageSceneDetailVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ImageSceneDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface ImageSceneDetailVoConverter
    extends BaseConverter<ImageSceneDetailVo, ImageSceneDetail> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlImage",
        source = "urlImage",
        qualifiedByName = {"util", "urlImage"})
  })
  ImageSceneDetailVo to(ImageSceneDetail imageSceneDetail);
}
