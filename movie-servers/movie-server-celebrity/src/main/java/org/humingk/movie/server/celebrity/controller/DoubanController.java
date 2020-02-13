package org.humingk.movie.server.celebrity.controller;

import org.humingk.movie.api.celebrity.DoubanApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/** @author humingk */
@RestController
public class DoubanController implements DoubanApi {
  @Override
  public Result bases(@NotNull Long id) {
    return null;
  }

  @Override
  public Result basesList(@NotEmpty List<Long> idList) {
    return null;
  }

  @Override
  public Result details(@NotNull Long id) {
    return null;
  }

  @Override
  public Result awards(Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }

  @Override
  public Result cooperatorsBases(
      Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }

  @Override
  public Result searchDetails(
      @NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
    return null;
  }
}
