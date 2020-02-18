package org.humingk.movie.dal.domain.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.Scene;

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
public class SceneAllDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景基础信息 */
  private Scene scene;
  /** 场景详情详细信息列表 */
  private List<SceneDetailAllDo> sceneDetailAllDoList;
  /** 场景地点详细信息 */
  private PlaceSceneAllDo placeSceneAllDo;
}
