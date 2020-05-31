package org.humingk.movie.dal.domain.scene.all;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.scene.CelebritySceneOfSceneDetailDo;
import org.humingk.movie.dal.entity.ImageSceneDetail;
import org.humingk.movie.dal.entity.SceneDetail;

import java.io.Serializable;
import java.util.List;

/**
 * 场景详情的详细信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneDetailAllDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景详情基础信息 */
  private SceneDetail sceneDetail;
  /** 场景详情图片列表 */
  private List<ImageSceneDetail> imageSceneDetailList;
  /** 场景详情的相关场景影人列表 */
  private List<CelebritySceneOfSceneDetailDo> celebritySceneOfSceneDetailDoList;
}
