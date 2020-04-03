package org.humingk.movie.api.common.converter.scene.brief;

import org.humingk.movie.api.common.converter.scene.ImagePlaceSceneVoConverter;
import org.humingk.movie.api.common.converter.scene.PlaceSceneVoConverter;
import org.humingk.movie.api.common.vo.scene.PlaceSceneBriefVo;
import org.humingk.movie.dal.domain.scene.brief.PlaceSceneBriefDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {PlaceSceneVoConverter.class, ImagePlaceSceneVoConverter.class})
public interface PlaceSceneBriefVoConverter {
  @Mappings({
    @Mapping(target = "base", source = "placeScene"),
    @Mapping(target = "imageList", source = "imagePlaceSceneList")
  })
  PlaceSceneBriefVo to(PlaceSceneBriefDo placeSceneBriefDo);
}
