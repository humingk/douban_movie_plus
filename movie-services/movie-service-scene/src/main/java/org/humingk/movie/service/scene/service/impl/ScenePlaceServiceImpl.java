package org.humingk.movie.service.scene.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.dal.entity.PlaceSceneExample;
import org.humingk.movie.dal.mapper.auto.PlaceSceneMapper;
import org.humingk.movie.service.scene.converter.PlaceSceneDtoConverter;
import org.humingk.movie.service.scene.dto.PlaceSceneDto;
import org.humingk.movie.service.scene.service.ScenePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
public class ScenePlaceServiceImpl implements ScenePlaceService {
  /** mapper */
  @Autowired private PlaceSceneMapper placeSceneMapper;
  /** example */
  @Autowired private PlaceSceneExample placeSceneExample;
  /** converter */
  @Autowired private PlaceSceneDtoConverter placeSceneDtoConverter;

  @Override
  public List<PlaceSceneDto> getPlaceSceneListByPlaceKeywordStart(
      String keyword, int offset, int limit) {
    String keywordNew = keyword.trim() + "%";
    placeSceneExample.start().andNameZhLike(keywordNew);
    placeSceneExample.or().andNameEnLike(keywordNew);
    placeSceneExample.or().andNameOtherLike(keywordNew);
    placeSceneExample.or().andAliasLike(keywordNew);
    PageHelper.offsetPage(offset, limit);
    return placeSceneDtoConverter.toList(placeSceneMapper.selectByExample(placeSceneExample));
  }
}
