package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.vo.scene.CelebritySceneOfSceneDetailVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.scene.CelebritySceneOfSceneDetailDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {})
public interface CelebritySceneOfSceneDetailVoConverter
    extends BaseConverter<CelebritySceneOfSceneDetailVo, CelebritySceneOfSceneDetailDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
    @Mapping(target = "idSceneDetail", source = "sceneDetailToCelebrityScene.idSceneDetail")
  })
  CelebritySceneOfSceneDetailVo to(CelebritySceneOfSceneDetailDo celebritySceneOfSceneDetailDo);
}
