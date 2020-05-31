package org.humingk.movie.api.common.converter.scene.brief;

import org.humingk.movie.api.common.converter.scene.SceneVoConverter;
import org.humingk.movie.api.common.vo.scene.SceneBriefVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.scene.brief.SceneBriefDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {SceneVoConverter.class, PlaceSceneBriefVoConverter.class})
public interface SceneBriefVoConverter extends BaseConverter<SceneBriefVo, SceneBriefDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "scene"),
    @Mapping(target = "place", source = "placeSceneBriefDo")
  })
  SceneBriefVo to(SceneBriefDo sceneBriefDo);
}
