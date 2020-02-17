package org.humingk.movie.service.douban.converter.celebrity;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchTipsCelebrityDoubanDo;
import org.humingk.movie.service.douban.dto.celebrity.SearchTipsCelebrityDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanDtoConverter.class})
public interface SearchTipsCelebrityDoubanDtoConverter
    extends BaseConverter<SearchTipsCelebrityDoubanDto, SearchTipsCelebrityDoubanDo> {
  @Override
  @Mappings({@Mapping(target = "celebrityDoubanDto", source = "celebrityDouban")})
  SearchTipsCelebrityDoubanDto to(SearchTipsCelebrityDoubanDo searchTipsCelebrityDoubanDo);
}
