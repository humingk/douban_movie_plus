package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.SearchTipsDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchTipsDoubanVo;
import org.humingk.movie.api.search.SearchDoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class SearchDoubanController implements SearchDoubanApi {
  @Autowired private MovieDoubanService movieDoubanService;
  @Autowired private CelebrityDoubanService celebrityDoubanService;
  @Autowired private SearchTipsDoubanVoConverter searchTipsDoubanVoConverter;

  @Override
  public Result<SearchTipsDoubanVo> searchTips(
      @NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return Result.success(
        searchTipsDoubanVoConverter.to(
            movieDoubanService.getSearchTipsMovieDoubanListByMovieDoubanKeywordStart(
                keyword, offset, limit),
            celebrityDoubanService.getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
                keyword, offset, limit)));
  }

  @Override
  public Result searchDetails(
      @NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }
}
