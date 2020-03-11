package org.humingk.movie.service.scene.converter;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.service.scene.dto.MovieSceneDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieSceneDtoConverter extends BaseConverter<MovieSceneDto, MovieScene> {}
