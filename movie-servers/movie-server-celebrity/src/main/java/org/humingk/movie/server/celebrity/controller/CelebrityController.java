package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.CelebrityApi;
import org.humingk.movie.api.common.converter.CelebrityDetailsVoConverter;
import org.humingk.movie.api.common.converter.CelebrityVoConverter;
import org.humingk.movie.api.common.vo.CelebrityDetailsVo;
import org.humingk.movie.api.common.vo.CelebrityVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.humingk.movie.service.imdb.service.CelebrityImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class CelebrityController implements CelebrityApi {
  /** service */
  @Autowired private CelebrityDoubanService celebrityDoubanService;

  @Autowired private CelebrityImdbService celebrityImdbService;
  /** converter */
  @Autowired private CelebrityVoConverter celebrityVoConverter;

  @Autowired private CelebrityDetailsVoConverter celebrityDetailsVoConverter;

  @Override
  public Result<CelebrityVo> bases(@NotNull Long id) {
    return Result.success(
        celebrityVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanByCelebrityDoubanId(id),
            celebrityImdbService.getCelebrityImdbByCelebrityDoubanId(id)));
  }

  @Override
  public Result<CelebrityDetailsVo> details(@NotNull Long id) {
    return Result.success(
        celebrityDetailsVoConverter.to(
            celebrityDoubanService.getCelebrityDoubanDetailsByCelebrityDoubanId(id),
            celebrityImdbService.getCelebrityImdbDetailsByCelebrityDoubanId(id)));
  }
}
