package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景详情剧照
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageSceneDetailVo implements Serializable {
  /** 场景详情剧照ID */
  private Long id;

  /** 场景详情ID */
  private Long idSceneDetail;

  /** 图片链接 */
  private String urlImage;

  private static final long serialVersionUID = 1L;
}
