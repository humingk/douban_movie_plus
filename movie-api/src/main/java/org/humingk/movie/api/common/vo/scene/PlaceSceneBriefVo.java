package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PlaceSceneBriefVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景地点基础信息 */
  private PlaceSceneVo base;
  /** 场景地点图片列表 */
  private List<ImagePlaceSceneVo> imageList;
}
