package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景详情
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SceneDetail implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景详情ID */
  private Long id;
  /** 场景ID */
  private Long idScene;
  /** 场景电影ID */
  private Long idMovieScene;
  /** 场景发生在电影中的时间 /s */
  private Integer happenTime;
  /** 场景描述 */
  private String description;
}
