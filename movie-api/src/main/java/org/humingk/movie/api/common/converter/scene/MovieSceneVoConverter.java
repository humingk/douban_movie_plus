package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.scene.MovieSceneVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieScene;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieSceneVoConverter extends BaseConverter<MovieSceneVo, MovieScene> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieScene",
        source = "id",
        qualifiedByName = {"util", "urlMovieScene"}),
    @Mapping(
        target = "urlMovieDouban",
        source = "idMovieDouban",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(
        target = "urlMap",
        source = "urlMap",
        qualifiedByName = {"util", "urlMap"}),
  })
  MovieSceneVo to(MovieScene movieScene);
}
