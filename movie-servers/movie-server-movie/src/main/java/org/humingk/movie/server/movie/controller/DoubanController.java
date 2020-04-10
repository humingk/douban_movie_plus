package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.movie.ClassicOfMovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.api.movie.DoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class DoubanController implements DoubanApi {
  @Autowired private MovieDoubanService movieDoubanService;
  @Autowired private MovieDoubanVoConverter movieDoubanVoConverter;
  @Autowired private MovieDoubanDetailsVoConverter movieDoubanDetailsVoConverter;
  @Autowired private ClassicOfMovieDoubanVoConverter classicOfMovieDoubanVoConverter;

  @Override
  public Result<MovieDoubanVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieDoubanVoConverter.to(movieDoubanService.getMovieDoubanByMovieDoubanId(id)));
  }

  @Override
  public Result<MovieDoubanDetailsVo> details(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieDoubanDetailsVoConverter.to(
            movieDoubanService.getMovieDoubanDetailsByMovieDoubanId(id)));
  }
}
