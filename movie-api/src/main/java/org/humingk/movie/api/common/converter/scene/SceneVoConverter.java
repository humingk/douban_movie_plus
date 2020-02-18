package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.SceneVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.Scene;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface SceneVoConverter extends BaseConverter<SceneVo, Scene> {
  @Override
  @Mapping(
      target = "urlMovieScene",
      source = "idMovieScene",
      qualifiedByName = {"util", "urlMovieScene"})
  SceneVo to(Scene scene);
}
