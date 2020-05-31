package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneVo implements Serializable {
  /** 场景ID */
  private Long id;

  /** 场景电影ID */
  private Long idMovieScene;

  /** 场景电影链接 */
  private String urlMovieScene;

  /** 地点ID */
  private Long idPlaceScene;

  /** 场景中文名 */
  private String nameZh;

  /** 场景发生在电影中的时间 /s */
  private Integer happenTime;

  private static final long serialVersionUID = 1L;
}
