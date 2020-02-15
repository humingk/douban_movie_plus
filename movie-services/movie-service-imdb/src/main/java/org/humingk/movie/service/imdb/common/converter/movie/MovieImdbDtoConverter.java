package org.humingk.movie.service.imdb.common.converter.movie;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieImdbDtoConverter extends BaseConverter<MovieImdbDto, MovieImdb> {}
