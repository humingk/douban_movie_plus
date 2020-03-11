package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.SearchTipsCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.SearchTipsMovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchTipsDoubanVo;
import org.humingk.movie.dal.domain.SearchTipsCelebrityDoubanDo;
import org.humingk.movie.dal.domain.SearchTipsMovieDoubanDo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public abstract class SearchTipsDoubanVoConverter {
  @Autowired private SearchTipsMovieDoubanVoConverter searchTipsMovieDoubanVoConverter;
  @Autowired private SearchTipsCelebrityDoubanVoConverter searchTipsCelebrityDoubanVoConverter;
  @Autowired private CelebrityDoubanVoConverter celebrityDoubanVoConverter;

  public SearchTipsDoubanVo to(
      List<SearchTipsMovieDoubanDo> searchTipsMovieDoubanDoList,
      List<SearchTipsCelebrityDoubanDo> searchTipsCelebrityDoubanDoList) {
    return new SearchTipsDoubanVo(
        searchTipsMovieDoubanVoConverter.toList(searchTipsMovieDoubanDoList),
        searchTipsCelebrityDoubanVoConverter.toList(searchTipsCelebrityDoubanDoList));
  }
}
