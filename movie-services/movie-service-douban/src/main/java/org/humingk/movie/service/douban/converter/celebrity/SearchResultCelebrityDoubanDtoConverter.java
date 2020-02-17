package org.humingk.movie.service.douban.converter.celebrity;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchResultCelebrityDoubanDo;
import org.humingk.movie.service.douban.dto.celebrity.SearchResultCelebrityDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanDtoConverter.class})
public interface SearchResultCelebrityDoubanDtoConverter
    extends BaseConverter<SearchResultCelebrityDoubanDto, SearchResultCelebrityDoubanDo> {
  @Override
  @Mappings({@Mapping(target = "celebrityDoubanDto", source = "celebrityDouban")})
  SearchResultCelebrityDoubanDto to(SearchResultCelebrityDoubanDo searchResultCelebrityDoubanDo);
}
