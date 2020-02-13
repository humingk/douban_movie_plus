package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.movie.RateApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class RateController implements RateApi {
  @Override
  public Result details(@NotNull Long id) {
    return null;
  }
}
