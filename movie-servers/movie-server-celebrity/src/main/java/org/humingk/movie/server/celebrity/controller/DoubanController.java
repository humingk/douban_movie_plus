package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.DoubanApi;
import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Result<CelebrityDoubanVo> bases(@NotNull Long id) {
    return Result.success(
        celebrityDoubanVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanByCelebrityDoubanId(id)));
  }

  @Override
  public Result<CelebrityDoubanDetailsVo> details(@NotNull Long id) {
    return Result.success(
        celebrityDoubanDetailsVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanDetailsByCelebrityDoubanId(id)));
  }
  // ----------

  @Override
  public Result cooperatorsBases(
      Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }
}
