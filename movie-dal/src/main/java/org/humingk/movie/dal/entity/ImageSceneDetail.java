package org.humingk.movie.dal.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class ImageSceneDetail implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景详情剧照ID */
  private Long id;
  /** 场景详情ID */
  private Long idSceneDetail;
  /** 图片链接 */
  private String urlImage;
}
