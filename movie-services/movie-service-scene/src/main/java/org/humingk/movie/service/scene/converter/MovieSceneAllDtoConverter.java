package org.humingk.movie.service.scene.converter;

import org.humingk.movie.dal.domain.scene.all.SceneAllDo;
import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieSceneAllDtoConverter {
  default MovieSceneAllDto to(MovieScene movieScene, List<SceneAllDo> sceneAllDoList) {
    return new MovieSceneAllDto(movieScene, sceneAllDoList);
  }
}
