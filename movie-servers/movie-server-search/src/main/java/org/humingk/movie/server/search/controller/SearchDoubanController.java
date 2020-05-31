package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.SearchResultDoubanVoConverter;
import org.humingk.movie.api.common.converter.SearchTipsDoubanVoConverter;
import org.humingk.movie.api.common.vo.SearchResultDoubanVo;
import org.humingk.movie.api.common.vo.SearchTipsDoubanVo;
import org.humingk.movie.api.search.SearchDoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class SearchDoubanController implements SearchDoubanApi {
  @Autowired private MovieDoubanService movieDoubanService;
  @Autowired private CelebrityDoubanService celebrityDoubanService;
  @Autowired private SearchTipsDoubanVoConverter searchTipsDoubanVoConverter;
  @Autowired private SearchResultDoubanVoConverter searchResultDoubanVoConverter;

  @Override
  public Result<SearchTipsDoubanVo> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        searchTipsDoubanVoConverter.to(
            movieDoubanService.getSearchTipsMovieDoubanListByMovieDoubanKeywordStart(
                keyword, offset, limit),
            celebrityDoubanService.getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
                keyword, offset, limit)));
  }

  @Override
  public Result<SearchResultDoubanVo> details(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        searchResultDoubanVoConverter.to(
            movieDoubanService.getSearchResultMovieDoubanListByMovieDoubanKeyword(
                keyword.trim(), offset, limit),
            celebrityDoubanService.getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword(
                keyword.trim(), offset, limit)));
  }
}
