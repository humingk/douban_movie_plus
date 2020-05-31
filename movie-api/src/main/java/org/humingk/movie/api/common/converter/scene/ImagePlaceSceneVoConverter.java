package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.ImagePlaceSceneVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ImagePlaceScene;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface ImagePlaceSceneVoConverter
    extends BaseConverter<ImagePlaceSceneVo, ImagePlaceScene> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlImage",
        source = "urlImage",
        qualifiedByName = {"util", "urlImage"})
  })
  ImagePlaceSceneVo to(ImagePlaceScene imagePlaceScene);
}
