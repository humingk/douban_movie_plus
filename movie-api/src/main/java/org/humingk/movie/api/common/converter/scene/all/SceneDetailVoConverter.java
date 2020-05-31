package org.humingk.movie.api.common.converter.scene.all;

import org.humingk.movie.api.common.vo.scene.SceneDetailVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.SceneDetail;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface SceneDetailVoConverter extends BaseConverter<SceneDetailVo, SceneDetail> {}
