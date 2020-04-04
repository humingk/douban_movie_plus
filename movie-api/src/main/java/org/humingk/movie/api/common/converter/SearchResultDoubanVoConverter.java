package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.SearchResultCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.SearchResultMovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchResultDoubanVo;
import org.humingk.movie.service.douban.dto.celebrity.SearchResultCelebrityDoubanDto;
import org.humingk.movie.service.douban.dto.movie.SearchResultMovieDoubanDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public abstract class SearchResultDoubanVoConverter {
  @Autowired private SearchResultMovieDoubanVoConverter searchResultMovieDoubanVoConverter;
  @Autowired private SearchResultCelebrityDoubanVoConverter searchResultCelebrityDoubanVoConverter;

  public SearchResultDoubanVo to(
      List<SearchResultMovieDoubanDto> searchResultMovieDoubanDtoList,
      List<SearchResultCelebrityDoubanDto> searchResultCelebrityDoubanDtoList) {
    return new SearchResultDoubanVo(
        searchResultMovieDoubanVoConverter.toList(searchResultMovieDoubanDtoList),
        searchResultCelebrityDoubanVoConverter.toList(searchResultCelebrityDoubanDtoList));
  }
}
