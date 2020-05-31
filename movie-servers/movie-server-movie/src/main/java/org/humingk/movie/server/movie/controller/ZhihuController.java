package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.ZhihuVoConverter;
import org.humingk.movie.api.common.vo.ZhihuVo;
import org.humingk.movie.api.movie.ZhihuApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.zhihu.service.ZhihuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class ZhihuController implements ZhihuApi {
  @Autowired private ZhihuService zhihuService;
  @Autowired private ZhihuVoConverter zhihuVoConverter;

  @Override
  public Result<ZhihuVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(zhihuVoConverter.to(zhihuService.getMovieZhihuByMovieDoubanId(id)));
  }
}
