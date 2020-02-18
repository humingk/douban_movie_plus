package org.humingk.movie.dal.domain.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.SceneDetailToCelebrityScene;

import java.io.Serializable;

/**
 * 场景详情的相关场景影人
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebritySceneOfSceneDetailDo implements Serializable {
  // celebrityScene ------------------------------

  /** 场景影人ID */
  private Long id;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;

  /** 场景影人中文名 */
  private String nameZh;

  /** 场景影人英文名 */
  private String nameEn;

  // SceneDetailToCelebrityScene ----------------------

  /** 场景详情-场景影人 */
  private SceneDetailToCelebrityScene sceneDetailToCelebrityScene;

  private static final long serialVersionUID = 1L;
}
