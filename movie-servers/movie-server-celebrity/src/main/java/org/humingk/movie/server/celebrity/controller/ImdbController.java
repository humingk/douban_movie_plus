package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.ImdbApi;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbDetailsVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.imdb.service.CelebrityImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class ImdbController implements ImdbApi {
  /** service */
  @Autowired private CelebrityImdbService celebrityImdbService;
  /** converter */
  @Autowired private CelebrityImdbVoConverter celebrityImdbVoConverter;

  @Autowired private CelebrityImdbDetailsVoConverter celebrityImdbDetailsVoConverter;

  @Override
  public Result<CelebrityImdbVo> bases(@NotNull Long id) {
    return Result.success(
        celebrityImdbVoConverter.to(celebrityImdbService.getCelebrityImdbByCelebrityImdbId(id)));
  }

  @Override
  public Result<CelebrityImdbDetailsVo> details(@NotNull Long id) {
    return Result.success(
        celebrityImdbDetailsVoConverter.to(
            celebrityImdbService.getCelebrityImdbDetailsByCelebrityImdbId(id)));
  }
}
