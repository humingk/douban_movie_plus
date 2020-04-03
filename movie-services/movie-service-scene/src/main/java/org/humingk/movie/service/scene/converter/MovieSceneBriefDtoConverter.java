package org.humingk.movie.service.scene.converter;

import org.humingk.movie.dal.domain.scene.brief.SceneBriefDo;
import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieSceneBriefDtoConverter {
  default MovieSceneBriefDto to(MovieScene movieScene, List<SceneBriefDo> sceneBriefDoList) {
    return new MovieSceneBriefDto(movieScene, sceneBriefDoList);
  }
}
