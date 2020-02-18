package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 场景详细信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneAllVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景基础信息 */
  private SceneVo base;
  /** 场景详情详细信息列表 */
  private List<SceneDetailAllVo> sceneDetailList;
  /** 场景地点详细信息 */
  private PlaceSceneAllVo place;
}
