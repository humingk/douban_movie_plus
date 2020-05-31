package org.humingk.movie.server.scene.controller;

import org.humingk.movie.api.common.converter.MovieSceneAllVoConverter;
import org.humingk.movie.api.common.converter.MovieSceneBriefVoConverter;
import org.humingk.movie.api.common.vo.MovieSceneAllVo;
import org.humingk.movie.api.common.vo.MovieSceneBriefVo;
import org.humingk.movie.api.scene.MovieApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.scene.service.SceneMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/** @author humingk */
@RestController
public class MovieController implements MovieApi {

  @Autowired private SceneMovieService sceneMovieService;
  @Autowired private MovieSceneBriefVoConverter movieSceneBriefVoConverter;
  @Autowired private MovieSceneAllVoConverter movieSceneAllVoConverter;

  @Override
  public Result<MovieSceneBriefVo> bases(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieSceneBriefVoConverter.to(sceneMovieService.getMovieSceneBriefByMovieDoubanId(id)));
  }

  @Override
  public Result<MovieSceneAllVo> details(@RequestParam("id") @NotNull Long id) {
    return Result.success(
        movieSceneAllVoConverter.to(sceneMovieService.getMovieSceneAllByMovieDoubanId(id)));
  }
}
