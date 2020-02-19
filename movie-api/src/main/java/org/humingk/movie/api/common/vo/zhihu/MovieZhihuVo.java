package org.humingk.movie.api.common.vo.zhihu;

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
@AllArgsConstructor
@NoArgsConstructor
public class MovieZhihuVo implements Serializable {
  /** 知乎电影ID */
  private Long id;

  /** 知乎话题链接 */
  private String urlZhihuTopic;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣电影链接 */
  private String urlMovieDouban;

  /** 知乎电影中文名 */
  private String nameZh;

  /** 知乎评分 */
  private BigDecimal zhihuScore;

  /** 知乎评分票数 */
  private Integer zhihuVote;

  /** 猫眼评分 */
  private BigDecimal maoyanScore;

  private static final long serialVersionUID = 1L;
}
