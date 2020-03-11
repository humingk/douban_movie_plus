package org.humingk.movie.service.scene.converter;

import org.humingk.movie.dal.domain.scene.SceneBriefDo;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.humingk.movie.service.scene.dto.MovieSceneDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring", uses = MovieSceneDtoConverter.class)
public interface MovieSceneBriefDtoConverter {
  default MovieSceneBriefDto to(MovieSceneDto movieSceneDto, List<SceneBriefDo> sceneBriefDoList) {
    return new MovieSceneBriefDto(movieSceneDto, sceneBriefDoList);
  }
}
