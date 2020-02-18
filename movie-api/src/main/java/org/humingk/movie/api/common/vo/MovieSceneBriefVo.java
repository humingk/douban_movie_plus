package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.scene.MovieSceneVo;
import org.humingk.movie.api.common.vo.scene.SceneBriefVo;

import java.io.Serializable;
import java.util.List;

/**
 * 场景简略信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSceneBriefVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景电影基础信息 */
  private MovieSceneVo base;
  /** 场景地点简略信息 */
  private List<SceneBriefVo> sceneList;
}
