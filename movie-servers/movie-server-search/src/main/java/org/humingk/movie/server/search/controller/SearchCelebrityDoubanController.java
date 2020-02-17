package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.api.search.SearchCelebrityDoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/** @author humingk */
@RestController
public class SearchCelebrityDoubanController implements SearchCelebrityDoubanApi {
  @Autowired private CelebrityDoubanVoConverter celebrityDoubanVoConverter;

  @Autowired private CelebrityDoubanService celebrityDoubanService;

  @Override
  public Result<List<CelebrityDoubanVo>> searchTips(
      @NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return Result.success(
        celebrityDoubanVoConverter.toList(
            celebrityDoubanService.getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
                keyword.trim(), offset, limit)));
  }

  @Override
  public Result searchDetails(
      @NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }
}
