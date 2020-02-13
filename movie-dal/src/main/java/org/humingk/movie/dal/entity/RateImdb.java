package org.humingk.movie.dal.entity;

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
public class RateImdb implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB电影ID tt+00xxx(7) */
  private Long id;
  /** IMDB评分 */
  private BigDecimal imdbScore;
  /** IMDB评分人数 */
  private Integer imdbVote;
  /** 烂番茄新鲜度 */
  private BigDecimal tomatoScore;
  /** MTC评分 */
  private BigDecimal mtcScore;
}
