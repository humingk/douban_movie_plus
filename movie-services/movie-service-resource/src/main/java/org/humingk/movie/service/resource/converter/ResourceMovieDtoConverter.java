package org.humingk.movie.service.resource.converter;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ResourceMovie;
import org.humingk.movie.service.resource.dto.ResourceMovieDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ResourceMovieDtoConverter extends BaseConverter<ResourceMovieDto, ResourceMovie> {}
