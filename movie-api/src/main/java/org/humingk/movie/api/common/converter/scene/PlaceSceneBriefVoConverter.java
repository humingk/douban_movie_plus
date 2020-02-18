package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.vo.scene.PlaceSceneBriefVo;
import org.humingk.movie.dal.entity.ImagePlaceScene;
import org.humingk.movie.dal.entity.PlaceScene;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {PlaceSceneVoConverter.class, ImagePlaceSceneVoConverter.class})
public interface PlaceSceneBriefVoConverter {
  @Mappings({
    @Mapping(target = "base", source = "placeScene"),
    @Mapping(target = "imageList", source = "imagePlaceSceneList")
  })
  PlaceSceneBriefVo to(
      /** 场景地点基础信息 */
      PlaceScene placeScene,
      /** 场景地点图片列表 */
      List<ImagePlaceScene> imagePlaceSceneList);
}
