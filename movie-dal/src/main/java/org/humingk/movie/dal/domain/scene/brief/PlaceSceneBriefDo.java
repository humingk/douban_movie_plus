package org.humingk.movie.dal.domain.scene.brief;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.ImagePlaceScene;
import org.humingk.movie.dal.entity.PlaceScene;

import java.io.Serializable;
import java.util.List;

/**
 * 场景地点简略信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSceneBriefDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景地点基础信息 */
  private PlaceScene placeScene;
  /** 场景地点图片列表 */
  private List<ImagePlaceScene> imagePlaceSceneList;
}
