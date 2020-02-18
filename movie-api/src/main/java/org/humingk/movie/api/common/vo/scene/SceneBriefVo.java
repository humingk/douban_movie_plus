package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.Scene;

import java.io.Serializable;

/**
 * 场景简略信息
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneBriefVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景基础信息 */
  private Scene base;
  /** 场景地点简略信息 */
  private PlaceSceneBriefVo place;
}
