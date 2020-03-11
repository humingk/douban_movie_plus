package org.humingk.movie.service.scene.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.scene.SceneAllDo;

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
public class MovieSceneAllDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景电影基础信息 */
  private MovieSceneDto movieSceneDto;
  /** 场景详细信息列表 */
  private List<SceneAllDo> sceneAllDoList;
}
