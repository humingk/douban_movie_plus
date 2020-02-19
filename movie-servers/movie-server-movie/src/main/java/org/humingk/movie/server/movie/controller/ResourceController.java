package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.ResourceMovieVoConverter;
import org.humingk.movie.api.common.vo.ResourceMovieVo;
import org.humingk.movie.api.movie.ResourceApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/** @author humingk */
@RestController
public class ResourceController implements ResourceApi {
  @Autowired private ResourceMovieVoConverter resourceMovieVoConverter;
  @Autowired private ResourceService resourceService;

  @Override
  public Result<List<ResourceMovieVo>> bases(@NotNull Long id) {
    return Result.success(
        resourceMovieVoConverter.toList(resourceService.getResourceListByMovieDoubanId(id)));
  }
}
