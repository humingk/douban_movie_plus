package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电影评分
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieVo implements Serializable {
  /** 豆瓣电影ID */
  private Long id;
}
