package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.movie.MovieImdbDetailsVoConverter;
import org.humingk.movie.api.common.converter.movie.MovieImdbVoConverter;
import org.humingk.movie.api.common.vo.movie.MovieImdbDetailsVo;
import org.humingk.movie.api.common.vo.movie.MovieImdbVo;
import org.humingk.movie.api.movie.ImdbApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.imdb.service.MovieImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class ImdbController implements ImdbApi {
  @Autowired private MovieImdbService movieImdbService;
  @Autowired private MovieImdbVoConverter movieImdbVoConverter;
  @Autowired private MovieImdbDetailsVoConverter movieImdbDetailsVoConverter;

  @Override
  public Result<MovieImdbVo> bases(@NotNull Long id) {
    return Result.success(movieImdbVoConverter.to(movieImdbService.getMovieImdbByMovieImdbId(id)));
  }

  @Override
  public Result<MovieImdbDetailsVo> details(@NotNull Long id) {
    return Result.success(
        movieImdbDetailsVoConverter.to(movieImdbService.getMovieImdbDetailsByMovieImdbId(id)));
  }
}
