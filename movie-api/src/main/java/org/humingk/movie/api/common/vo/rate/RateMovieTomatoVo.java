package org.humingk.movie.api.common.vo.rate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 烂番茄电影新鲜度
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateMovieTomatoVo implements Serializable {
  /** 烂番茄电影评分 */
  private BigDecimal score;
  /** 烂番茄电影评分人数 */
  private Integer vote;
}
