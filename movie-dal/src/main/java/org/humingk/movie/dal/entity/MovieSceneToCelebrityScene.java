package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景电影-场景影人
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSceneToCelebrityScene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景电影ID */
  private Long idMovieScene;
  /** 场景影人ID */
  private Long idCelebrityScene;
}
