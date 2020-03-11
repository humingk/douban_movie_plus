package org.humingk.movie.service.scene.converter;

import org.humingk.movie.dal.domain.scene.SceneAllDo;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.humingk.movie.service.scene.dto.MovieSceneDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring", uses = MovieSceneDtoConverter.class)
public interface MovieSceneAllDtoConverter {
  default MovieSceneAllDto to(MovieSceneDto movieSceneDto, List<SceneAllDo> sceneAllDoList) {
    return new MovieSceneAllDto(movieSceneDto, sceneAllDoList);
  }
}
