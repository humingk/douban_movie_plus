package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.scene.MovieSceneVoConverter;
import org.humingk.movie.api.common.converter.scene.brief.SceneBriefVoConverter;
import org.humingk.movie.api.common.vo.MovieSceneBriefVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieSceneVoConverter.class, SceneBriefVoConverter.class})
public interface MovieSceneBriefVoConverter
    extends BaseConverter<MovieSceneBriefVo, MovieSceneBriefDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "movieScene"),
    @Mapping(target = "sceneList", source = "sceneBriefDoList")
  })
  MovieSceneBriefVo to(MovieSceneBriefDto movieSceneBriefDto);
}
