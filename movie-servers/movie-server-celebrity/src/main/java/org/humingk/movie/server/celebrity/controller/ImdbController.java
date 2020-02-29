package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.ImdbApi;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbDetailsVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.imdb.service.CelebrityImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class ImdbController implements ImdbApi {
  /** service */
  @Autowired private CelebrityImdbService celebrityImdbService;
  /** converter */
  @Autowired private CelebrityImdbVoConverter celebrityImdbVoConverter;

  @Autowired private CelebrityImdbDetailsVoConverter celebrityImdbDetailsVoConverter;

  @Override
  public Result<CelebrityImdbVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        celebrityImdbVoConverter.to(celebrityImdbService.getCelebrityImdbByCelebrityImdbId(id)));
  }

  @Override
  public Result<CelebrityImdbDetailsVo> details(
      @RequestParam("id") @NotNull Long id,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        celebrityImdbDetailsVoConverter.to(
            celebrityImdbService.getCelebrityImdbDetailsByCelebrityImdbId(id, limit)));
  }
}
