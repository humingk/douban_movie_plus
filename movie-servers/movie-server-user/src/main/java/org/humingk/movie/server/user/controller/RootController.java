package org.humingk.movie.server.user.controller;

import org.humingk.movie.api.user.RootApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class RootController implements RootApi {
  @Override
  public Result usersList(@PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }
}
