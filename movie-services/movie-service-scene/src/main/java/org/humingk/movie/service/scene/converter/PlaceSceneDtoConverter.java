package org.humingk.movie.service.scene.converter;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.PlaceScene;
import org.humingk.movie.service.scene.dto.PlaceSceneDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface PlaceSceneDtoConverter extends BaseConverter<PlaceSceneDto, PlaceScene> {}
