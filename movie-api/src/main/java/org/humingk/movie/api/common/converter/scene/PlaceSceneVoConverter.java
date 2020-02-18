package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.PlaceSceneVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.PlaceScene;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface PlaceSceneVoConverter extends BaseConverter<PlaceSceneVo, PlaceScene> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlPoster",
        source = "urlPoster",
        qualifiedByName = {"util", "urlImage"}),
    @Mapping(
        target = "urlEarth",
        source = "urlEarth",
        qualifiedByName = {"util", "urlImage"}),
    @Mapping(
        target = "urlSatellite",
        source = "urlSatellite",
        qualifiedByName = {"util", "urlImage"}),
    @Mapping(
        target = "urlMap",
        source = "urlMap",
        qualifiedByName = {"util", "urlMap"})
  })
  PlaceSceneVo to(PlaceScene placeScene);
}
