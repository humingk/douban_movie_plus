package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.search.SearchResourceApi;
import org.springframework.web.bind.annotation.RestController;

/** @author humingk */
@RestController
public class SearchResourceController implements SearchResourceApi {

  //  @Autowired private ResourceMovieVoConverter resourceMovieVoConverter;
  //  @Autowired private ResourceService resourceService;
  //
  //  @Override
  //  public Result<List<ResourceMovieVo>> details(
  //      @RequestParam("keyword") @NotBlank String keyword,
  //      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
  //          Integer offset,
  //      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
  //          Integer limit) {
  //    return Result.success(
  //        resourceMovieVoConverter.toList(
  //            resourceService.getResourceListByKeyword(keyword, offset, limit)));
  //  }
}
