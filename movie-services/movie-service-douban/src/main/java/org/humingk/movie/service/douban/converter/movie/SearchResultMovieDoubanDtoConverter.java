package org.humingk.movie.service.douban.converter.movie;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchResultMovieDoubanDo;
import org.humingk.movie.service.douban.dto.movie.SearchResultMovieDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieDoubanDtoConverter.class})
public interface SearchResultMovieDoubanDtoConverter
    extends BaseConverter<SearchResultMovieDoubanDto, SearchResultMovieDoubanDo> {
  @Override
  @Mappings({@Mapping(target = "movieDoubanDto", source = "movieDouban")})
  SearchResultMovieDoubanDto to(SearchResultMovieDoubanDo searchResultMovieDoubanDo);
}
