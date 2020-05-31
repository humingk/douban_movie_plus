package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.movie.ResourceApi;
import org.springframework.web.bind.annotation.RestController;

/** @author humingk */
@RestController
public class ResourceController implements ResourceApi {
  //  @Autowired private ResourceMovieVoConverter resourceMovieVoConverter;
  //  @Autowired private ResourceService resourceService;
  //
  //  @Override
  //  public Result<List<ResourceMovieVo>> bases(
  //      @RequestParam("id") @NotNull Long id,
  //      @RequestParam(value = "limit", required = false, defaultValue = "30") @PositiveOrZero
  //          Integer limit) {
  //    return Result.success(
  //        resourceMovieVoConverter.toList(resourceService.getResourceListByMovieDoubanId(id,
  // limit)));
  //  }
}
