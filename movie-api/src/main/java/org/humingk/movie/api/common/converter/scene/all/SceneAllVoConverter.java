package org.humingk.movie.api.common.converter.scene.all;

import org.humingk.movie.api.common.converter.scene.SceneVoConverter;
import org.humingk.movie.api.common.vo.scene.SceneAllVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.scene.all.SceneAllDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      SceneVoConverter.class,
      SceneDetailAllVoConverter.class,
      PlaceSceneAllVoConverter.class
    })
public interface SceneAllVoConverter extends BaseConverter<SceneAllVo, SceneAllDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "scene"),
    @Mapping(target = "sceneDetailList", source = "sceneDetailAllDoList"),
    @Mapping(target = "place", source = "placeSceneAllDo")
  })
  SceneAllVo to(SceneAllDo sceneAllDo);
}
