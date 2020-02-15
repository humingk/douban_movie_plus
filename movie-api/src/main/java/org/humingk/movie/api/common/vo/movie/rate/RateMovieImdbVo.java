package org.humingk.movie.api.common.vo.movie.rate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * IMDB电影评分，包括MTC、烂番茄新鲜度
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieImdbVo implements Serializable {
  /** IMDB电影ID */
  private String idMovieImdb;

  /** IMDB评分 */
  private BigDecimal imdbScore;

  /** IMDB评分人数 */
  private Integer imdbVote;

  /** 烂番茄新鲜度 */
  private BigDecimal tomatoScore;

  /** MTC评分 */
  private BigDecimal mtcScore;
}
