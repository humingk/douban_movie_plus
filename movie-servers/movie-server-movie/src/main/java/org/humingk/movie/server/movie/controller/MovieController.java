package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.MovieDetailsVoConverter;
import org.humingk.movie.api.common.converter.MovieVoConverter;
import org.humingk.movie.api.common.vo.MovieDetailsVo;
import org.humingk.movie.api.common.vo.MovieVo;
import org.humingk.movie.api.movie.MovieApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.humingk.movie.service.imdb.service.MovieImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class MovieController implements MovieApi {
  /** service */
  @Autowired private MovieDoubanService movieDoubanService;

  @Autowired private MovieImdbService movieImdbService;
  /** converter */
  @Autowired private MovieVoConverter movieVoConverter;

  @Autowired private MovieDetailsVoConverter movieDetailsVoConverter;

  @Override
  public Result<MovieVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieVoConverter.to(
            movieDoubanService.getMovieDoubanByMovieDoubanId(id),
            movieImdbService.getMovieImdbByMovieDoubanId(id)));
  }

  @Override
  public Result<MovieDetailsVo> details(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieDetailsVoConverter.to(
            movieDoubanService.getMovieDoubanDetailsByMovieDoubanId(id),
            movieImdbService.getMovieImdbDetailsByMovieDoubanId(id)));
  }
}
