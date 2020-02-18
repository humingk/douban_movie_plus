package org.humingk.movie.dal.domain.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.*;

import java.io.Serializable;
import java.util.List;

/**
 * 场景地点详细信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSceneAllDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景地点基础信息 */
  private PlaceScene placeScene;
  /** 场景地点图片列表 */
  private List<ImagePlaceScene> imagePlaceSceneList;
  /** 场景地点-类型列表 */
  private List<PlaceSceneToTypePlaceScene> placeSceneToTypePlaceSceneList;
  /** 场景地点 洲 */
  private ContinentScene continentScene;
  /** 场景地点 国家 */
  private CountryScene countryScene;
  /** 场景地点 城市 */
  private CityScene cityScene;
  /** 场景地点 州/省 */
  private StateScene stateScene;
}
