package org.humingk.movie.service.scene.service;

import org.humingk.movie.service.scene.dto.PlaceSceneDto;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 场景地点服务
 *
 * @author humingk
 */
@Validated
public interface ScenePlaceService {
  /**
   * 获取场景地点列表
   *
   * @param keyword 地点名称关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<PlaceSceneDto> getPlaceSceneListByPlaceKeywordStart(String keyword, int offset, int limit);
}
