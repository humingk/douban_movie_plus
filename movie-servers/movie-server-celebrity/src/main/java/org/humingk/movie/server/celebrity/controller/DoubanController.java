package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.DoubanApi;
import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class DoubanController implements DoubanApi {
  /** service */
  @Autowired private CelebrityDoubanService celebrityDoubanService;
  /** converter */
  @Autowired private CelebrityDoubanVoConverter celebrityDoubanVoConverter;

  @Autowired private CelebrityDoubanDetailsVoConverter celebrityDoubanDetailsVoConverter;

  @Override
  public Result<CelebrityDoubanVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        celebrityDoubanVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanByCelebrityDoubanId(id)));
  }

  @Override
  public Result<CelebrityDoubanDetailsVo> details(
      @RequestParam("id") @NotNull Long id,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        celebrityDoubanDetailsVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanDetailsByCelebrityDoubanId(id, limit)));
  }
  // ----------

  @Override
  public Result cooperatorsBases(
      @RequestParam("id") Long id,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return null;
  }
}
