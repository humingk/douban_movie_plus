package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.scene.MovieSceneVo;
import org.humingk.movie.api.common.vo.scene.SceneAllVo;

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
public class MovieSceneAllVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景电影基础信息 */
  private MovieSceneVo base;
  /** 场景详细信息列表 */
  private List<SceneAllVo> sceneList;
}
