package org.humingk.movie.service.douban.common.converter.movie;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieDoubanDtoConverter extends BaseConverter<MovieDoubanDto, MovieDouban> {}
