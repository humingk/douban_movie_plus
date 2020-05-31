package org.humingk.movie.api.common.converter.scene.all;

import org.humingk.movie.api.common.converter.scene.ImagePlaceSceneVoConverter;
import org.humingk.movie.api.common.converter.scene.PlaceSceneVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.PlaceSceneAllVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.scene.all.PlaceSceneAllDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class, PlaceSceneVoConverter.class, ImagePlaceSceneVoConverter.class})
public interface PlaceSceneAllVoConverter extends BaseConverter<PlaceSceneAllVo, PlaceSceneAllDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "placeScene"),
    @Mapping(target = "imageList", source = "imagePlaceSceneList"),
    @Mapping(
        target = "typeList",
        source = "placeSceneToTypePlaceSceneList",
        qualifiedByName = {"util", "typeListScene"}),
    @Mapping(
        target = "continent",
        source = "continentScene",
        qualifiedByName = {"util", "continentScene"}),
    @Mapping(
        target = "country",
        source = "countryScene",
        qualifiedByName = {"util", "countryScene"}),
    @Mapping(
        target = "city",
        source = "cityScene",
        qualifiedByName = {"util", "cityScene"}),
    @Mapping(
        target = "state",
        source = "stateScene",
        qualifiedByName = {"util", "stateScene"})
  })
  PlaceSceneAllVo to(PlaceSceneAllDo placeSceneAllDo);
}
