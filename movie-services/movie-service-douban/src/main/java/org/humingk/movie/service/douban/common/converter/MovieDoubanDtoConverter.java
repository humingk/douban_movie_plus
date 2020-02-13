package org.humingk.movie.service.douban.common.converter;

import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.service.douban.common.dto.MovieDoubanDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieDoubanDtoConverter {
  MovieDoubanDto to(MovieDouban movieDouban);
}
