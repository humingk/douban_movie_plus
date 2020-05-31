package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.scene.MovieSceneVoConverter;
import org.humingk.movie.api.common.vo.scene.MovieSceneVo;
import org.humingk.movie.api.search.SearchMovieSceneApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.scene.service.SceneMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/** @author humingk */
@RestController
public class SearchMovieSceneController implements SearchMovieSceneApi {
  @Autowired private SceneMovieService sceneMovieService;
  @Autowired private MovieSceneVoConverter movieSceneVoConverter;

  @Override
  public Result<List<MovieSceneVo>> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        movieSceneVoConverter.toList(
            sceneMovieService.getMovieSceneListByMovieSceneKeywordStart(
                keyword.trim(), offset, limit)));
  }
}
