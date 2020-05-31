package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.scene.MovieSceneVoConverter;
import org.humingk.movie.api.common.converter.scene.all.SceneAllVoConverter;
import org.humingk.movie.api.common.vo.MovieSceneAllVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieSceneVoConverter.class, SceneAllVoConverter.class})
public interface MovieSceneAllVoConverter extends BaseConverter<MovieSceneAllVo, MovieSceneAllDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "movieScene"),
    @Mapping(target = "sceneList", source = "sceneAllDoList")
  })
  MovieSceneAllVo to(MovieSceneAllDto movieSceneAllDto);
}
