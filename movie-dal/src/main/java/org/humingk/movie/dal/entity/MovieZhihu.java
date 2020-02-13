package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 知乎电影
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieZhihu implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 知乎电影ID */
  private Long id;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 知乎电影中文名 */
  private String nameZh;
  /** 知乎评分 */
  private BigDecimal zhihuScore;
  /** 知乎评分票数 */
  private Integer zhihuVote;
  /** 猫眼评分 */
  private BigDecimal maoyanScore;
}
