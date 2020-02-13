package org.humingk.movie.api.common.vo.rate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * MTC电影评分
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieMtcVo implements Serializable {
  /** MTC电影评分 */
  private BigDecimal score;
  /** MTC电影评分人数 */
  private Integer vote;
}
