package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.SearchResultCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.SearchResultMovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchResultDoubanVo;
import org.humingk.movie.dal.domain.SearchResultCelebrityDoubanDo;
import org.humingk.movie.dal.domain.SearchResultMovieDoubanDo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public abstract class SearchResultDoubanVoConverter {
  @Autowired private SearchResultMovieDoubanVoConverter searchResultMovieDoubanVoConverter;
  @Autowired private SearchResultCelebrityDoubanVoConverter searchResultCelebrityDoubanVoConverter;

  public SearchResultDoubanVo to(
      List<SearchResultMovieDoubanDo> searchResultMovieDoubanDoList,
      List<SearchResultCelebrityDoubanDo> searchResultCelebrityDoubanDoList) {
    return new SearchResultDoubanVo(
        searchResultMovieDoubanVoConverter.toList(searchResultMovieDoubanDoList),
        searchResultCelebrityDoubanVoConverter.toList(searchResultCelebrityDoubanDoList));
  }
}
