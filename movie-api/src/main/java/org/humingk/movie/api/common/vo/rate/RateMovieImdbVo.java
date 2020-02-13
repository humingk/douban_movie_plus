package org.humingk.movie.api.common.vo.rate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * IMDB电影评分
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieImdbVo implements Serializable {
  /** IMDB电影ID */
  private Long id;
  /** IMDB电影评分 */
  private BigDecimal score;
  /** IMDB电影评分人数 */
  private Integer vote;
}
