package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 豆瓣电影评分
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long id;
  /** 豆瓣电影评分 */
  private BigDecimal score;
  /** 豆瓣电影评分人数 */
  private Integer vote;
  /** 豆瓣5星比例 */
  private BigDecimal score5;
  /** 豆瓣4星比例 */
  private BigDecimal score4;
  /** 豆瓣3星比例 */
  private BigDecimal score3;
  /** 豆瓣2星比例 */
  private BigDecimal score2;
  /** 豆瓣1星比例 */
  private BigDecimal score1;
}
