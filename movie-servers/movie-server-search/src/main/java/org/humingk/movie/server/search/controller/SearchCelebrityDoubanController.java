package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.celebrity.SearchResultCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.SearchTipsCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.SearchResultCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.celebrity.SearchTipsCelebrityDoubanVo;
import org.humingk.movie.api.search.SearchCelebrityDoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/** @author humingk */
@RestController
public class SearchCelebrityDoubanController implements SearchCelebrityDoubanApi {
  @Autowired private SearchTipsCelebrityDoubanVoConverter searchTipsCelebrityDoubanVoConverter;

  @Autowired private SearchResultCelebrityDoubanVoConverter searchResultCelebrityDoubanVoConverter;

  @Autowired private CelebrityDoubanService celebrityDoubanService;

  @Override
  public Result<List<SearchTipsCelebrityDoubanVo>> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        searchTipsCelebrityDoubanVoConverter.toList(
            celebrityDoubanService.getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
                keyword.trim(), offset, limit)));
  }

  @Override
  public Result<List<SearchResultCelebrityDoubanVo>> details(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        searchResultCelebrityDoubanVoConverter.toList(
            celebrityDoubanService.getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword(
                keyword.trim(), offset, limit)));
  }
}
