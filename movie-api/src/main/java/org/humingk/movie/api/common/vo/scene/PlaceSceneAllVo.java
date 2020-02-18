package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PlaceSceneAllVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景地点基础信息 */
  private PlaceSceneVo base;
  /** 场景地点图片列表 */
  private List<ImagePlaceSceneVo> imageList;
  /** 场景地点-类型列表 */
  private List<String> typeList;
  /** 场景地点 洲 */
  private String continent;
  /** 场景地点 国家 */
  private String country;
  /** 场景地点 城市 */
  private String city;
  /** 场景地点 州/省 */
  private String state;
}
