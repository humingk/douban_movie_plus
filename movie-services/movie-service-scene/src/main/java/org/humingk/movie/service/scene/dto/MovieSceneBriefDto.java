package org.humingk.movie.service.scene.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.scene.SceneBriefDo;
import org.humingk.movie.dal.entity.MovieScene;

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
public class MovieSceneBriefDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景电影基础信息 */
  private MovieScene movieScene;
  /** 场景地点简略信息 */
  private List<SceneBriefDo> sceneBriefDoList;
}
