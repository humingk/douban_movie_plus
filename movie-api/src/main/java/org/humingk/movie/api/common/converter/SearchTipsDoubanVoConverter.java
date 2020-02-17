package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.SearchTipsMovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchTipsDoubanVo;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDto;
import org.humingk.movie.service.douban.dto.movie.SearchTipsMovieDoubanDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public abstract class SearchTipsDoubanVoConverter {
  @Autowired private SearchTipsMovieDoubanVoConverter searchTipsMovieDoubanVoConverter;
  @Autowired private CelebrityDoubanVoConverter celebrityDoubanVoConverter;

  public SearchTipsDoubanVo to(
      List<SearchTipsMovieDoubanDto> searchTipsMovieDoubanDtoList,
      List<CelebrityDoubanDto> celebrityDoubanDtoList) {
    return new SearchTipsDoubanVo(
        searchTipsMovieDoubanVoConverter.toList(searchTipsMovieDoubanDtoList),
        celebrityDoubanVoConverter.toList(celebrityDoubanDtoList));
  }
}
