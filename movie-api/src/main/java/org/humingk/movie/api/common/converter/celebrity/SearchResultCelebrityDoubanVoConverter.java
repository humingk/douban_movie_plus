package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.converter.celebrity.details.AliasCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.details.MovieDoubanOfCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.SearchResultCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.douban.dto.celebrity.SearchResultCelebrityDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      CelebrityDoubanVoConverter.class,
      AliasCelebrityDoubanVoConverter.class,
      MovieDoubanOfCelebrityDoubanVoConverter.class
    })
public interface SearchResultCelebrityDoubanVoConverter
    extends BaseConverter<SearchResultCelebrityDoubanVo, SearchResultCelebrityDoubanDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "celebrityDouban"),
    @Mapping(target = "aliasList", source = "aliasCelebrityDoubanList"),
    @Mapping(target = "movieList", source = "movieDoubanOfCelebrityDoubanDoList")
  })
  SearchResultCelebrityDoubanVo to(SearchResultCelebrityDoubanDto searchResultCelebrityDoubanDto);
}
