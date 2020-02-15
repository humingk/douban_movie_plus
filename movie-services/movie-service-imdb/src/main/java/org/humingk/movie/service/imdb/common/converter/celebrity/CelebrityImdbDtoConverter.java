package org.humingk.movie.service.imdb.common.converter.celebrity;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.service.imdb.common.dto.celebrity.CelebrityImdbDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface CelebrityImdbDtoConverter extends BaseConverter<CelebrityImdbDto, CelebrityImdb> {}
