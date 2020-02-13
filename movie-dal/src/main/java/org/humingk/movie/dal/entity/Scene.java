package org.humingk.movie.dal.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class Scene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景ID */
  private Long id;
  /** 场景电影ID */
  private Long idMovieScene;
  /** 地点ID */
  private Long idPlaceScene;
  /** 场景中文名 */
  private String nameZh;
  /** 场景发生在电影中的时间 /s */
  private Integer happenTime;
}
