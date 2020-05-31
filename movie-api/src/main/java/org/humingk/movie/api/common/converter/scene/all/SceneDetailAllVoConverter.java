package org.humingk.movie.api.common.converter.scene.all;

import org.humingk.movie.api.common.converter.scene.CelebritySceneOfSceneDetailVoConverter;
import org.humingk.movie.api.common.vo.scene.SceneDetailAllVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.scene.all.SceneDetailAllDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      SceneDetailVoConverter.class,
      ImageSceneDetailVoConverter.class,
      CelebritySceneOfSceneDetailVoConverter.class
    })
public interface SceneDetailAllVoConverter
    extends BaseConverter<SceneDetailAllVo, SceneDetailAllDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "sceneDetail"),
    @Mapping(target = "imageList", source = "imageSceneDetailList"),
    @Mapping(target = "celebrityList", source = "celebritySceneOfSceneDetailDoList")
  })
  SceneDetailAllVo to(SceneDetailAllDo sceneDetailAllDo);
}
