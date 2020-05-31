package org.humingk.movie.service.scene.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.PlaceScene;
import org.humingk.movie.dal.entity.PlaceSceneExample;
import org.humingk.movie.dal.mapper.auto.PlaceSceneMapper;
import org.humingk.movie.service.scene.service.ScenePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class ScenePlaceServiceImpl implements ScenePlaceService {
  /** mapper */
  @Autowired private PlaceSceneMapper placeSceneMapper;
  /** example */
  @Autowired private PlaceSceneExample placeSceneExample;

  @Override
  public List<PlaceScene> getPlaceSceneListByKeyword(String keyword, int offset, int limit) {
    placeSceneExample.start().andNameZhLike(keyword.trim());
    placeSceneExample.or().andNameEnLike(keyword.trim());
    placeSceneExample.or().andNameOtherLike(keyword.trim());
    placeSceneExample.or().andAliasLike(keyword.trim());
    PageHelper.offsetPage(offset, limit);
    return placeSceneMapper.selectByExample(placeSceneExample);
  }

  @Override
  public List<PlaceScene> getPlaceSceneListByPlaceKeywordStart(
      String keyword, int offset, int limit) {
    List<PlaceScene> placeSceneList = getPlaceSceneListByKeyword(keyword + "%", offset, limit);
    if (placeSceneList.isEmpty()) {
      placeSceneList = getPlaceSceneListByKeyword(keyword + "%", offset, limit);
    }
    return placeSceneList;
  }
}
