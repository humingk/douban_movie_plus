package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SceneDetailAllVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景详情基础信息 */
  private SceneDetailVo base;
  /** 场景详情图片列表 */
  private List<ImageSceneDetailVo> imageList;
  /** 场景详情的相关场景影人列表 */
  private List<CelebritySceneOfSceneDetailVo> celebrityList;
}
