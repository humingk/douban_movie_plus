package org.humingk.movie.server.search.controller;

import org.humingk.movie.api.common.converter.scene.PlaceSceneVoConverter;
import org.humingk.movie.api.common.vo.scene.PlaceSceneVo;
import org.humingk.movie.api.search.SearchPlaceSceneApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.scene.service.ScenePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/** @author humingk */
@RestController
public class SearchPlaceSceneController implements SearchPlaceSceneApi {
  @Autowired private ScenePlaceService scenePlaceService;
  @Autowired private PlaceSceneVoConverter placeSceneVoConverter;

  @Override
  public Result<List<PlaceSceneVo>> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        placeSceneVoConverter.toList(
            scenePlaceService.getPlaceSceneListByPlaceKeywordStart(keyword.trim(), offset, limit)));
  }
}
